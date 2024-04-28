package plus.jqm.hello.auth.web;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import plus.jqm.hello.auth.domain.LoginRequest;
import plus.jqm.hello.auth.exception.UsernameOrPasswordException;
import plus.jqm.hello.auth.util.PermissionUtils;
import plus.jqm.hello.common.api.domain.SysRoleDO;
import plus.jqm.hello.common.api.domain.SysUserDetailsDO;
import plus.jqm.hello.common.api.service.RemoteUserService;
import plus.jqm.hello.common.core.constant.AuthConstants;
import plus.jqm.hello.common.core.util.R;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用户登录模块
 *
 * @author xjq
 * @date 2024/04/23
 */
@Tag(name = "用户认证模块", description = "login-controller")
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LoginController {
    private final RemoteUserService remoteUserService;

    @Operation(summary = "用户登录", description = "传入用户名密码进行身份认证")
    @PostMapping("/login")
    public R<Object> login(@RequestBody LoginRequest loginRequest) {
        R<SysUserDetailsDO> r = this.remoteUserService.getUserDetailsByUsername(loginRequest.getUsername());
        SysUserDetailsDO userDetailsDO = r.getData();
        if (Objects.isNull(userDetailsDO) || !BCrypt.checkpw(loginRequest.getPassword(), userDetailsDO.getPassword())) {
            throw new UsernameOrPasswordException("user.login.failure");
        }
        StpUtil.login(userDetailsDO.getId(), new SaLoginModel().setExtra(AuthConstants.LOGIN_USERNAME, userDetailsDO.getUsername()));
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        Map<String, List<String>> rolePermissionMap = userDetailsDO.getRoleList().stream().collect(Collectors.toMap(SysRoleDO::getCode, SysRoleDO::getPermissionList, (a, b) -> a));
        PermissionUtils.cachePermission(rolePermissionMap);
        return R.ok(tokenInfo);
    }

    @Operation(summary = "用户登出", description = "用户登出")
    @GetMapping("/logout")
    public R<Object> logout() {
        StpUtil.logout();
        return R.ok();
    }
}
