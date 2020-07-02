package club.tinysme.lsongseven.hello.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.annotation.PreDestroy;

/**
 * @Author liang.song liang.song@envision-digital.com
 * @Date 2020/4/15 13:31
 */
@SpringBootApplication
@ServletComponentScan
public class HelloWorld {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("shutdown hook!")));
        SpringApplication.run(HelloWorld.class);
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }
}
