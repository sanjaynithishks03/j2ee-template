package com.helloworld.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Basic servlet that renders a plain HTML greeting to demonstrate the
 * Maven/J2EE project template wiring.
 */
public class HelloWorldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String contextPath = req.getContextPath();
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Hello World</title></head><body>");
            out.println("<h1>Hello, World!</h1>");
            out.println("<p>This is a basic J2EE servlet example.</p>");
            out.println("<p><a href='" + contextPath + "/'>Back to Home</a></p>");
            out.println("</body></html>");
        }
    }
}
