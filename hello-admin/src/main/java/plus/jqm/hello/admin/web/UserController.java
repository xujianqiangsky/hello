package plus.jqm.hello.admin.web;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.jqm.hello.admin.domain.UserDO;
import plus.jqm.hello.admin.domain.vo.UserVO;
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
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 根据 id 查询用户信息
     *
     * @param id 用户 id
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public R<UserVO> getUserById(@PathVariable("id") long id) {
        UserDO userDO = this.userService.getById(id);
        UserVO userVO = BeanUtil.copyProperties(userDO, UserVO.class);
        return R.ok(userVO);
    }
}
