package annotationaop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName annotationaop
 * @Author joel
 * @Date 2019/1/25 14:37
 **/
@Configuration
public class Melon {
    // 使用注解声明Bean对象

    @Bean
    public Melon melon() {
        return new Melon();
    }

    public void changePrice() {
        System.out.println("melon also need change peice...");
    }
}
