package plus.jqm.hello.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.stereotype.Service;
import plus.jqm.hello.admin.domain.UserDO;
import plus.jqm.hello.admin.domain.UserVO;
import plus.jqm.hello.admin.mapper.UserMapper;
import plus.jqm.hello.admin.service.UserService;

/**
 * User 业务逻辑实现
 *
 * @author xjq
 * @date 2024/04/16
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {this.userMapper = userMapper;}

    @Override
    public UserVO getUserById(long id) {
        UserDO userDO = this.userMapper.getUserById(id);
        return BeanUtil.copyProperties(userDO, UserVO.class);
    }

    @Override
    public UserVO getUserByUsername(String username) {
        UserDO userDO = this.userMapper.getUserByUsername(username);
        return BeanUtil.copyProperties(userDO, UserVO.class);
    }
}
