package plus.jqm.hello.common.api.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author xjq
 * @date 2024/04/27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dept")
public class SysDeptDO extends AbstractBaseDO {
    @Serial
    private static final long serialVersionUID = -5873962627681061919L;
    @TableId
    private Long id;
    private Long parentId;
    private String name;
    private Integer sort;
    /**
     * 逻辑删除：0 未删除 1 已删除
     */
    @TableField("is_deleted")
    private Integer deleted;
}
