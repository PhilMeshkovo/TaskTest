package controller;

import service.MathService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mathServlet")
public class MathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("hello.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MathService mathService = new MathService();
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        PrintWriter writer = response.getWriter();
        try {
            double[] answer = mathService.compute(a, b, c);
            String htmlRespone = "<html>";
            htmlRespone += "<h2>Your D is: " + answer[0] + "<br/>";
            htmlRespone += "Your answer is: " + answer[1] + "<br/>";
            htmlRespone += "and: " + answer[2] + "</h2>";
            htmlRespone += "</html>";

            writer.println(htmlRespone);
        } catch (Exception e) {
            String htmlRespone = "<html>";
            htmlRespone += "<h2>" + e.getMessage() + "</h2>";
            htmlRespone += "</html>";

            writer.println(htmlRespone);
        }
    }
}
