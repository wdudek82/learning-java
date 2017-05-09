package helloservlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Lesson41")
public class Lesson41 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("yourname");
        String theLang = request.getParameter("Language");
        int firstNum = Integer.parseInt(request.getParameter("fnumber"));
        int secondNum = Integer.parseInt(request.getParameter("snumber"));
        int sumOfNums = firstNum + secondNum;

        response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        output.println("<html><body><h3>Hello " + userName + "</h3>");
        output.println("<p>" + firstNum + " + " + secondNum + " = " + sumOfNums);
        output.println("Speaks the lang: " + theLang);
        output.println("</body></html>");
    }
}
