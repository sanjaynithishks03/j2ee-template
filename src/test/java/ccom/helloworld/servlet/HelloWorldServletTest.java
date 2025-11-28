package com.helloworld.servlet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

/**
 * Simple behavioural test for {@link HelloWorldServlet} that proves the servlet
 * renders the expected HTML and sets HTTP metadata correctly.
 */
class HelloWorldServletTest {

    @Test
    void doGetRendersHelloWorldPage() throws Exception {
        HelloWorldServlet servlet = new HelloWorldServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getContextPath()).thenReturn("/context");

        StringWriter buffer = new StringWriter();
        PrintWriter writer = new PrintWriter(buffer, true);
        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        String body = buffer.toString();
        assertTrue(body.contains("<h1>Hello, World!</h1>"));
        assertTrue(body.contains("<p>This is a basic J2EE servlet example.</p>"));
        assertTrue(body.contains("href='/context/'"));

        verify(response).setContentType("text/html; charset=UTF-8");
        verify(response).setCharacterEncoding("UTF-8");
    }
}
