package cnu.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan /*이걸 작성해줘야 GET 방식 가능*/
/*서블릿을 직접 등록해서 사용할 수 있도록 스프링부트에서 제공하는 어노테이션*/
@SpringBootApplication
/*서블릿 클래스를 정의하고 URL 매핑을 간편하게 설정하기 위한 어노테이션*/
public class MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

}
