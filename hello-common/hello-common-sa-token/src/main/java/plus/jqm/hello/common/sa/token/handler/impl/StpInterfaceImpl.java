package plus.jqm.hello.common.sa.token.handler.impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import plus.jqm.hello.common.core.constant.AuthConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限加载接口实现类
 *
 * @author xjq
 * @date 2024/04/25
 */
@Slf4j
public class StpInterfaceImpl implements StpInterface {

    static {
        SaSessionCustomUtil.sessionKey = AuthConstants.PERMISSION_CACHE_PREFIX;
    }

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> permissionList = new ArrayList<>();
        for (String roleId : getRoleList(loginId, loginType)) {
            SaSession roleSession = SaSessionCustomUtil.getSessionById(AuthConstants.ROLE_CACHE_PREFIX + roleId);
            List<String> permissionByRole = roleSession.get(AuthConstants.PERMISSION_CACHE_KEY, ArrayList::new);
            permissionList.addAll(permissionByRole);
        }
        return permissionList;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        SaSession session = StpUtil.getSessionByLoginId(loginId);
        return session.get(AuthConstants.ROLE_CACHE_KEY, ArrayList::new);
    }
}
