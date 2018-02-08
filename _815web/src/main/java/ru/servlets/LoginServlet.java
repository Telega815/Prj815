package ru.servlets;


import ru.test815.db.Controller;
import ru.test815.db.Settings;
import ru.test815.db.UserPackage.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;


import java.util.Collection;

@MultipartConfig(location="C:/Users/sei66/Desktop/Prj815/rep/tmp", fileSizeThreshold=1024*1024*20, maxFileSize=1024*1024*20*5, maxRequestSize=1024*1024*20*5*5)
public class LoginServlet extends HttpServlet {
    Settings settings = Settings.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");



    }

}
