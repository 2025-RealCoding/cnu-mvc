package cnu.mvc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        parseStartLine(request);
        parseHeaders(request);
        response.getWriter().write("ok");
    }
    private void parseStartLine(HttpServletRequest request) {
        System.out.println("============parseStartLine start===============");
        System.out.println("HTTP Method: " + request.getMethod()); // HTTP 메서드 (GET, POST 등)
        System.out.println("Request URL: " + request.getRequestURL()); // 요청 URL
        System.out.println("Request URI: " + request.getRequestURI()); // 요청 URI (/index.html 등)
        System.out.println("Protocol Version: " + request.getProtocol()); // 프로토콜 버전 (HTTP/1.1 등)
        System.out.println("============parseStartLine end===============");
    }
    private void parseHeaders(HttpServletRequest request){
        System.out.println("============parseHeaders start===============");
        // 요청 헤더 파싱
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue + "<br/>");
        }
        System.out.println("============parseHeaders end===============");
    }
}

