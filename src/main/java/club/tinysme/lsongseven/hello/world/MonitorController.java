package club.tinysme.lsongseven.hello.world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ming.wang4@envision-digital.com
 * @date 2019-06-22
 */
@RestController
@RequestMapping("/")
public class MonitorController {


    @GetMapping(value = "/actuator/health")
    public HealthCheckResponse requestResource() {
        return new HealthCheckResponse();
    }

    public static class HealthCheckResponse {
        public String message = "Service Up";
    }
}
