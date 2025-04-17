package cnu.mvc.servlet.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/query-param")
public class QueryParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 특정 파라미터 값 가져오기
        String name = request.getParameter("name"); // "name" 파라미터 값 추출
        String age = request.getParameter("age"); // "age" 파라미터 값 추출
        System.out.println("name: " + name);
        System.out.println("age: " + age);

        // 모든 쿼리 파라미터 출력하기
        System.out.println("\n모든 쿼리 파라미터:");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        response.getWriter().write("ok");
    }
}
