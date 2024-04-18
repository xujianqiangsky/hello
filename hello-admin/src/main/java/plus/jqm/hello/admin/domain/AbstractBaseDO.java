package plus.jqm.hello.admin.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 公共字段
 *
 * @author xjq
 * @date 2024/04/18
 */
@Data
public class AbstractBaseDO implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 逻辑删除：0 未删除 1 已删除
     */
    @TableField("is_deleted")
    private Integer deleted;
}
