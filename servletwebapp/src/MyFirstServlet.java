import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName PACKAGE_NAME
 * @Author joel
 * @Date 2019/1/10 10:09
 **/

// 使用 WebServlet 注解的方式，Servlet容器会自动注册你的Servlet到运行环境

@WebServlet(name = "MyFirstServlet", urlPatterns = {"/MyFirstServlet"})
public class MyFirstServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "hello world, this message is for my first servlet~";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> data = getData();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        try {
            // write some content
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<title>MyFirstServlet</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<h2>Servlet MyFirstServlet at " + req.getContextPath() + "</h2>");
            printWriter.println("<h2>" + message + "</h2>");
            printWriter.println("<h2>hello, " + data.get("username") + " : " + data.get("message") + "</h2>");
            printWriter.println("<h2>The time right now is : " + new Date() + "</h2>");
            printWriter.println("</body>");
            printWriter.println("</html>");
        } finally {
            printWriter.close();
        }
    }

    public Map<String, String> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("username", "joel");
        data.put("message", "welcome to my world!");
        return data;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pass
    }

    @Override
    public String getServletInfo() {
        // return "MyFirstServlet"
        return super.getServletInfo();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
