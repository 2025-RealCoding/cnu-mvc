package cnu.mvc.servlet.response;
import cnu.mvc.servlet.request.dto.MyDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("utf-8");
        MyDto myDto = new MyDto();
        myDto.setName("hong");
        myDto.setAge(22);
        String result = objectMapper.writeValueAsString(myDto);
        response.getWriter().write(result);
    }
}
