package plus.jqm.hello.common.api.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * @author xjq
 * @date 2024/04/27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRoleDO extends AbstractBaseDO {
    @Serial
    private static final long serialVersionUID = -2137612483390182140L;
    @TableId
    private Long id;
    private String name;
    private String code;
    private String desc;
    @TableField(exist = false)
    private List<String> permissionList;
    /**
     * 逻辑删除：0 未删除 1 已删除
     */
    @TableField("is_deleted")
    private Integer deleted;
}
