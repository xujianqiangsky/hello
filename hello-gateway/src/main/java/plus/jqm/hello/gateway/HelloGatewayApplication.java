package plus.jqm.hello.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主程序入口
 *
 * @author xjq
 * @date 2024/04/20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HelloGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloGatewayApplication.class, args);
    }
}
