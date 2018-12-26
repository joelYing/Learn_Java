package advance;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;


/**
 * @PackageName advance
 * @Author joel
 * @Date 2018/12/26 11:04
 **/
public class Slf4jExample {
    /**
     * Java日志框架：slf4j作用及其实现原理  -- > https://www.cnblogs.com/xrq730/p/8619156.html
     *
     * slf4j只做两件事情：
     *     提供日志接口
     *     提供获取具体日志对象的方法
     */
    private static final Logger logger = LoggerFactory.getLogger(Slf4jExample.class);

    public static void main(String[] args) {
        example();
    }

    public static void example() {
        String config = System.getProperty("user.dir") + File.separator + "config" + File.separator;

        PropertyConfigurator.configure(config +  "log4j.properties");

        String string1 = "string1";
        String string2 = "string2";

        logger.trace("trace log {} {}", string1, string2);
        logger.debug("debug log {}", string1);
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
