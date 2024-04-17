package plus.jqm.hello.admin.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.jqm.hello.admin.domain.UserVO;
import plus.jqm.hello.admin.service.UserService;
import plus.jqm.hello.common.util.R;

/**
 * 用户管理模块
 *
 * @author xjq
 * @date 2024/04/16
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    /**
     * 根据 id 查询用户信息
     *
     * @param id 用户 id
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public R<UserVO> getUserById(@PathVariable("id") long id) {
        UserVO userVO = this.userService.getUserById(id);
        return R.ok(userVO);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/name/{username}")
    public R<UserVO> getUserByUsername(@PathVariable("username") String username) {
        UserVO userVO = this.userService.getUserByUsername(username);
        return R.ok(userVO);
    }
}
