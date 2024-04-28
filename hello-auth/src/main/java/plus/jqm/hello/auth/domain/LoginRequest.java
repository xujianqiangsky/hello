package plus.jqm.hello.auth.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 登录请求参数封装
 *
 * @author xjq
 * @date 2024/04/23
 */
@Schema(description = "用户登录参数对象")
@Data
public class LoginRequest {
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "密码")
    private String password;
}
