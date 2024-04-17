package plus.jqm.hello.admin.service;

import plus.jqm.hello.admin.domain.UserVO;

/**
 * User 服务
 *
 * @author xjq
 * @date 2024/04/16
 */
public interface UserService {
    UserVO getUserById(long id);

    UserVO getUserByUsername(String username);
}
