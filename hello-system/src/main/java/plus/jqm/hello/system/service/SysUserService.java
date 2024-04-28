package plus.jqm.hello.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import plus.jqm.hello.common.api.domain.SysUserDO;
import plus.jqm.hello.common.api.domain.SysUserDetailsDO;
import plus.jqm.hello.common.api.domain.vo.SysUserVO;

/**
 * User 服务
 *
 * @author xjq
 * @date 2024/04/16
 */
public interface SysUserService extends IService<SysUserDO> {
    SysUserVO getUserByUsername(String username);

    SysUserDetailsDO getUserDetailsByUsername(String username);
}
