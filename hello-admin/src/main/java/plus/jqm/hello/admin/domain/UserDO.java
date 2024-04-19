package plus.jqm.hello.admin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * User 数据对象
 *
 * @author xjq
 * @date 2024/04/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("`user`")
public class UserDO extends AbstractBaseDO {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    private String username;
    private String nickname;
    /**
     * 性别：0 男 1 女 2 未知
     */
    private Integer gender;
    private String password;
    private String email;
    private String phoneNumber;
    private String avatar;
    /**
     * 账号状态：0 正常 1 停用
     */
    private Integer status;
    private Long deptId;
    @TableField("login_ip")
    private String loginIP;
    private LocalDateTime loginTime;
}
