package plus.jqm.hello.common.api.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * User 展示对象
 *
 * @author xjq
 * @date 2024/04/16
 */
@Data
@Schema(description = "用户展示对象")
public class SysUserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 7862234129610271949L;
    @Schema(description = "主键")
    private Long id;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "性别：0 男 1 女 2 未知")
    private Integer gender;
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "手机号码")
    private String phoneNumber;
    @Schema(description = "头像")
    private String avatar;
}
