package plus.jqm.hello.admin.web;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import plus.jqm.hello.admin.domain.UserDO;
import plus.jqm.hello.admin.domain.vo.UserVO;
import plus.jqm.hello.admin.service.UserService;
import plus.jqm.hello.common.core.util.R;

/**
 * 用户管理模块
 *
 * @author xjq
 * @date 2024/04/16
 */
@Tag(name = "用户管理模块", description = "user-controller")
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
    @Operation(summary = "获取用户信息", description = "根据 id 获取用户信息", parameters = {@Parameter(name = "id", description = "用户 id")})
    @GetMapping("/{id}")
    public R<UserVO> getUserById(@PathVariable("id") long id) {
        UserDO userDO = this.userService.getById(id);
        UserVO userVO = BeanUtil.copyProperties(userDO, UserVO.class);
        return R.ok(userVO);
    }
}
