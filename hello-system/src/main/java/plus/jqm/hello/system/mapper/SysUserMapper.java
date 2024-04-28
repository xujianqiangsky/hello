package plus.jqm.hello.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import plus.jqm.hello.common.api.domain.SysUserDO;
import plus.jqm.hello.common.api.domain.SysUserDetailsDO;

/**
 * User Mapper
 *
 * @author xjq
 * @date 2024/04/16
 */
public interface SysUserMapper extends BaseMapper<SysUserDO> {
    SysUserDetailsDO getUserDetailsById(@Param("id") long id);

    SysUserDetailsDO getUserDetailsByUsername(@Param("username") String username);
}
