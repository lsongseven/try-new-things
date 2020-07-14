package club.tinysme.lsongseven.hello.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.annotation.PreDestroy;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import static club.tinysme.lsongseven.hello.world.Constants.DATA_LOCATION;

/**
 * @Author liang.song liang.song@envision-digital.com
 * @Date 2020/4/15 13:31
 */
@SpringBootApplication
@ServletComponentScan
public class HelloWorld {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (InputStream in = new ByteArrayInputStream(String.format("shutdown hook: %s \r\n", new Date().toString()).getBytes())) {
                System.out.println("shutdown hook!");
                FileUtil.appendFile(in, DATA_LOCATION + "shutdown.hook");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        SpringApplication.run(HelloWorld.class);
    }

    @PreDestroy
    public void destroy() {
        try (InputStream in = new ByteArrayInputStream(String.format("destroy hook: %s \r\n", new Date().toString()).getBytes())) {
            System.out.println("destroy hook!");
            FileUtil.appendFile(in, DATA_LOCATION + "destroy.hook");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
