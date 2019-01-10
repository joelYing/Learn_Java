import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @PackageName PACKAGE_NAME
 * @Author joel
 * @Date 2019/1/10 11:04
 **/

// 使用 WebServlet 注解的方式，Servlet容器会自动注册你的Servlet到运行环境
// http://localhost:8080/servletwebapp/MySecondServlet?username=&password=

@WebServlet(name = "MySecondServlet", urlPatterns = {"/MySecondServlet"})
public class MySecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean success = validateUser(username, password);
        try {
            // write some content
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<title>LoginServlet</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            if (success) {
                printWriter.println("<h2>Welcome Friend</h2>");
            } else {
                printWriter.println("<h2>validate yourself again.</h2>");
            }
            printWriter.println("</body>");
            printWriter.println("</html>");
        } finally {
            printWriter.close();
        }
    }

    public boolean validateUser(String username, String password) {
        String myUserName = "joel";
        String myPassWord = "123456";
        if (username == null || password == null) {
            return false;
        }

        return myUserName.equals(username) && myPassWord.equals(password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pass
    }

    @Override
    public String getServletInfo() {
        return "MySecongServlet";
    }
}
