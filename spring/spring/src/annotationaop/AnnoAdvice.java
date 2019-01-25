package annotationaop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName annotationaop
 * @Author joel
 * @Date 2019/1/25 14:57
 **/

@Aspect
@Configuration
public class AnnoAdvice {
    // 使用注解注入Bean对象

    @Bean
    public AnnoAdvice annoAdvice() {
        return new AnnoAdvice();
    }

    @Pointcut("execution(* annotationaop.Melon.changePrice(..))")
    public void price() {
        System.out.println("this is price");
    }
    // 后置通知

    @After("price()")
    public void changeAfter() {
        System.out.println("after melon price change...");
    }


}
