package calc.Calculator3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// calc.Calculator3 패키지 내에서 컴포넌트를 스캔하고 빈으로 등록
@ComponentScan(basePackages = {"calc.Calculator3"})

// @Configuration 스프링의 설정 클래스
@Configuration
public class Config {

}
