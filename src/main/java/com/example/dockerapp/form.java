package com.example.dockerapp;


import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "form", value = "/form")
public class form extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    User user = new User();
    DAO dao = new DAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String name = request.getParameter("name");
            user.setName(name);
            dao.addUser(user);

            List<User>  getUsers = dao.getUsers();


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>Thanks!</title></head>");
        out.write("<body>");



            out.write("<table border ='1'>");
            out.write("<tr>");
            out.write("<th>id</th>");
            out.write("<th>name</th>");
            out.write("</tr>");


            for (User u: getUsers) {
                out.write("<tr>");
                out.write("<td>" + u.getId()+"</td>");
                out.write("<td>" + u.getName() +"</td>");
                out.write("</tr>");
            }

            out.write("</table>");


        out.write("<br><a href=\"index.jsp\">Back to Form</a>");
        out.write("</body></html>");




    }
}
 