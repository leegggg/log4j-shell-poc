package com.example.log4shell;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//import com.sun.deploy.net.HttpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = LogManager.getLogger(com.example.log4shell.log4j.class); // vulnerable code
        String userName = req.getParameter("uname");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        // System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        // logger.error("params:{}", "${jndi:ldap://127.0.0.1:1389/Log4jTest}");
        logger.error(req.getHeader("User-Agent")); // vulnerable code
        if (userName.equals("admin") && password.equals("password")) {
            out.println("Welcome Back Admin");
        } else {
            logger.error(userName); // vulnerable code
            out.println("<code> the password you entered was invalid, <u> we will log your information </u> </code>");
        }
    }

    public void destroy() {
    }
}