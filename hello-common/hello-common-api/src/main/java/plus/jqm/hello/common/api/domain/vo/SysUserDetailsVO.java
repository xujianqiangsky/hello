package plus.jqm.hello.common.api.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import plus.jqm.hello.common.api.domain.SysDeptDO;
import plus.jqm.hello.common.api.domain.SysRoleDO;

import java.io.Serial;
import java.util.List;

/**
 * UserDetails 展示对象
 *
 * @author xjq
 * @date 2024/04/27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "用户详细信息展示对象")
public class SysUserDetailsVO extends SysUserVO {
    @Serial
    private static final long serialVersionUID = 5432254597398442261L;
    @Schema(description = "用户权限列表")
    private List<String> permissionList;
    @Schema(description = "用户部门信息")
    private SysDeptDO dept;
    @Schema(description = "用户角色列表")
    private List<SysRoleDO> roleList;
}
