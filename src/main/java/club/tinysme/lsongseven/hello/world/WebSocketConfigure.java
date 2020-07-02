package club.tinysme.lsongseven.hello.world;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author congcong.chen
 * @date 2019-07-15 21:07
 * @email congcong.chen@envision-digital.com
 */
@Configuration
@EnableWebSocket
public class WebSocketConfigure {

    @Bean
    public ServerEndpointExporter serverEndpoint() {
        return new ServerEndpointExporter();
    }
}