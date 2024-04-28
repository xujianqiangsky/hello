package plus.jqm.hello.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import plus.jqm.hello.common.http.service.annotation.EnableHelloHttpServiceClients;

/**
 * 主程序入口
 *
 * @author xjq
 * @date 2024/04/21
 */
@EnableHelloHttpServiceClients("plus.jqm.hello.common.api.service")
@SpringBootApplication
@EnableDiscoveryClient
public class HelloAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloAuthApplication.class, args);
    }
}
