package plus.jqm.hello.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主程序入口
 *
 * @author xjq
 * @date 2024/04/16
 */
@MapperScan("plus.jqm.hello.admin.mapper")
@SpringBootApplication
public class HelloAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloAdminApplication.class, args);
    }
}
