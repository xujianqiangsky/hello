package plus.jqm.hello.system.web;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.jqm.hello.common.api.domain.SysUserDO;
import plus.jqm.hello.common.api.domain.SysUserDetailsDO;
import plus.jqm.hello.common.api.domain.vo.SysUserVO;
import plus.jqm.hello.common.core.util.R;
import plus.jqm.hello.system.service.SysUserService;

/**
 * 用户管理模块
 *
 * @author xjq
 * @date 2024/04/16
 */
@Tag(name = "用户管理模块", description = "user-controller")
@RestController
@RequestMapping(value = "/admin/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SysUserController {
    private final SysUserService sysUserService;

    @Operation(summary = "获取用户信息", description = "根据用户名称获取用户信息", parameters = {@Parameter(name = "username", description = "用户名称")})
    @GetMapping("/{id}")
    public R<SysUserVO> getUserByUsername(@PathVariable long id) {
        SysUserDO userDO = this.sysUserService.getById(id);
        SysUserVO userVO = BeanUtil.copyProperties(userDO, SysUserVO.class);
        return R.ok(userVO);
    }

    @Operation(summary = "获取用户信息", description = "根据用户名称获取用户信息", parameters = {@Parameter(name = "username", description = "用户名称")})
    @GetMapping("/name/{username}")
    public R<SysUserVO> getUserByUsername(@PathVariable String username) {
        SysUserVO userByUsername = this.sysUserService.getUserByUsername(username);
        return R.ok(userByUsername);
    }

    @Operation(summary = "获取用户详细信息", description = "根据用户名称获取用户详细信息", parameters = {@Parameter(name = "username", description = "用户名称")})
    @GetMapping("/detail/{username}")
    public R<SysUserDetailsDO> getUserDetailsByUsername(@PathVariable String username) {
        SysUserDetailsDO userDetailsByUsername = this.sysUserService.getUserDetailsByUsername(username);
        return R.ok(userDetailsByUsername);
    }
}
