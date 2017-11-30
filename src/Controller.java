import dao.DaoImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public Controller(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws IOException{
        processRequest(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        processRequest(request,response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        DaoImpl dao = new DaoImpl();
        String[] data = dao.getData(request.getParameter("firstname"), request.getParameter("lastname"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
        out.println("<title>Title</title>");
        out.println("</head><body>");

        /*out.println("It works!");
        out.println("Your name is " + request.getParameter("firstname") + " " + request.getParameter("lastname"));*/

        out.println("<table><tr>");
        out.println("<td>Name</td>");
        out.println("<td>Surname</td>");
        out.println("<td>Phone number</td>");
        out.println("<td>E-mail</td>");
        out.println("</tr><tr>");
        out.println("<td>"+ data[0] + "</td>");
        out.println("<td>"+ data[1] + "</td>");
        out.println("<td>"+ data[2] + "</td>");
        out.println("<td>"+ data[3] + "</td>");
        out.println("</tr></table>");
        out.println("</body></html>");
    }
}
