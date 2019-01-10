import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @PackageName PACKAGE_NAME
 * @Author joel
 * @Date 2019/1/10 12:24
 *
 * 权限过滤器
 **/

//@WebFilter(filterName = "LoginFilter", urlPatterns = "/hello",
//        initParams = {
//                @WebInitParam(name = "loginUI", value = "/home/loginUI"),
//                @WebInitParam(name = "loginProcess", value = "home/login"),
//                @WebInitParam(name = "encoding", value = "utf-8")
//        })

public class LoginFilter implements Filter {
    private FilterConfig config;
    @Override
    public void destroy() {
        this.config=null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //获取Filter配置参数
        String encoding=config.getInitParameter("encoding");
        String loginPage=config.getInitParameter("loginPage");
        String afterLogin=config.getInitParameter("afterLogin");
        //设置request编码
        request.setCharacterEncoding(encoding);
        HttpServletRequest requ=(HttpServletRequest) request;
        HttpSession session=requ.getSession();
        //获取客户请求页面
        String requestPath=requ.getServletPath();
        String name=requ.getParameter("username");
        if(name==""||name==null){
            System.out.println("权限拦截器的消息："+"终止");
            HttpServletResponse resq=(HttpServletResponse)response;
            resq.sendRedirect(requ.getContextPath()+loginPage);
        }else{
            System.out.println("权限拦截器的消息："+"放行");
            request.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
