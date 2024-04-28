package plus.jqm.hello.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plus.jqm.hello.common.api.domain.SysUserDO;
import plus.jqm.hello.common.api.domain.SysUserDetailsDO;
import plus.jqm.hello.common.api.domain.vo.SysUserVO;
import plus.jqm.hello.system.mapper.SysUserMapper;
import plus.jqm.hello.system.service.SysUserService;

/**
 * User 业务逻辑实现
 *
 * @author xjq
 * @date 2024/04/16
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDO> implements SysUserService {
    private final SysUserMapper sysUserMapper;

    @Override
    public SysUserVO getUserByUsername(String username) {
        LambdaQueryWrapper<SysUserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserDO::getUsername, username);
        SysUserDO sysUserDO = this.baseMapper.selectOne(wrapper);
        return BeanUtil.copyProperties(sysUserDO, SysUserVO.class);
    }

    @Override
    public SysUserDetailsDO getUserDetailsByUsername(String username) {
        return this.sysUserMapper.getUserDetailsByUsername(username);
    }
}
