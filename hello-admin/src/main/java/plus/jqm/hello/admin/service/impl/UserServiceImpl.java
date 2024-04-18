package plus.jqm.hello.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import plus.jqm.hello.admin.domain.UserDO;
import plus.jqm.hello.admin.domain.vo.UserVO;
import plus.jqm.hello.admin.mapper.UserMapper;
import plus.jqm.hello.admin.service.UserService;

/**
 * User 业务逻辑实现
 *
 * @author xjq
 * @date 2024/04/16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {}
