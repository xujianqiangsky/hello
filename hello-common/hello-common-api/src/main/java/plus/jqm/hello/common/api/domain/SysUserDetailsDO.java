package plus.jqm.hello.common.api.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

/**
 * 用户详细信息
 *
 * @author xjq
 * @date 2024/04/27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserDetailsDO extends SysUserDO {
    @Serial
    private static final long serialVersionUID = 5398523189955606657L;
    private SysDeptDO dept;
    private List<SysRoleDO> roleList;
}
