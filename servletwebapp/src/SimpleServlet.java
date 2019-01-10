import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @PackageName PACKAGE_NAME
 * @Author joel
 * @Date 2019/1/10 11:36
 *
 * 传递Servlet初始化参数
 **/
public class SimpleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();

        String value = getServletConfig().getInitParameter("name");
        try {
            // write some content
            printWriter.println("<html>");
            printWriter.println("<head>");
            printWriter.println("<title>SimpleServlet</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<h2>Servlet init param : value = " + value + "</h2>");
            printWriter.println("</body>");
            printWriter.println("</html>");
        } finally {
            printWriter.close();
        }
    }

    /**
     * 下载文件 未实现
     */
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String fileToDownload) throws IOException {
        final int BYTES = 1024;
        int length = 0;

        ServletOutputStream outputStream = response.getOutputStream();
        ServletContext context = getServletConfig().getServletContext();

        String mimeType = context.getMimeType(fileToDownload);
        response.setContentType(mimeType != null ? mimeType : "text/plain");
        response.setHeader("Content-Disposition", "attachment; filename='' + fileToDownload + '' ");

        InputStream in = context.getResourceAsStream("/" + fileToDownload);
        byte[] bytes = new byte[BYTES];

        while ((in != null) && ((length = in.read(bytes)) != -1)) {
            outputStream.write(bytes, 0, length);
        }

        outputStream.flush();
        outputStream.close();
    }

}
