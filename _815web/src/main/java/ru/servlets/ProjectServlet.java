package ru.servlets;


import ru.test815.db.Controller;
import ru.test815.db.UserPackage.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig(location="C:/TempShit/tmp", fileSizeThreshold=1024*1024*20, maxFileSize=1024*1024*20*5, maxRequestSize=1024*1024*20*5*5)
public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/Page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part: req.getParts()) {
            part.getSubmittedFileName();
        }

        Controller.getInstance().writeParts(new User(1, "Frank"), req.getParts());
        doGet(req, resp);
    }

}

