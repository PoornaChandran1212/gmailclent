package com.kg.gmailclient;

import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginController
 */
@WebServlet("/validateuser")
public class LoginController extends HttpServlet {
String action="";
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
            doGet(req, resp);
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet doGet");
        // switch("action")
        // {
            
        //     case "validateuser":
        //     validateUser(req,resp);
        //         break;
            
        //     default:
        //     System.out.println("default called");
        //     resp.sendRedirect("login.jsp");

        // }
        try {
            validateUser(req, resp);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    private void validateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        System.out.println("validate user called");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + password);

        Validation userController = new Validation();
        int a=userController.getLogin(username);
        if(a==1)
        {
            ServletContext context=getServletContext();
            context.setAttribute("email",username);
            resp.sendRedirect("home.jsp");
        }
        else{
            resp.sendRedirect("login.jsp");
        }
        
    }
}
