package aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @PackageName aop
 * @Author joel
 * @Date 2019/1/25 11:49
 **/
public class AroundAdvice {
    /**
     * 环绕通知使用 ProceedingJoinPoint 作为方法的入参
     */
    public void watchPrice(ProceedingJoinPoint joinPoint) {
        try {
            // 前置通知
            System.out.println("around: price change before...");
            // 执行被通知的方法
            joinPoint.proceed();
            // 后置通知
            System.out.println("around: price change after...");
        } catch (Throwable t) {
            System.out.println("around: change error...");
        }
    }
}
