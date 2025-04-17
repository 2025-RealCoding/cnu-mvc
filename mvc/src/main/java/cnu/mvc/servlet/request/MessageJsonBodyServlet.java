package cnu.mvc.servlet.request;
import cnu.mvc.servlet.request.dto.MyDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/message-json-body")
public class MessageJsonBodyServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);

        MyDto myDto = objectMapper.readValue(messageBody, MyDto.class);/*이 부분에서 MyDto로*/
        System.out.println("username = " + myDto.getName());
        System.out.println("age = " + myDto.getAge());
        response.getWriter().write("ok");
    }
}
