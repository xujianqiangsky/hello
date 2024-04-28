package plus.jqm.hello.auth.util;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import cn.dev33.satoken.stp.StpUtil;
import plus.jqm.hello.common.core.constant.AuthConstants;

import java.util.List;
import java.util.Map;

/**
 * 权限工具类
 *
 * @author xjq
 * @date 2024/04/26
 */
public final class PermissionUtils {
    private PermissionUtils() {}

    public static void cachePermission(Map<String, List<String>> permissionMap) {
        SaSession session = StpUtil.getSession();
        List<String> roleList = permissionMap.keySet().stream().toList();
        session.set(AuthConstants.ROLE_CACHE_KEY, roleList);
        SaSessionCustomUtil.sessionKey = AuthConstants.PERMISSION_CACHE_PREFIX;
        for (String roleId : roleList) {
            SaSession roleSession = SaSessionCustomUtil.getSessionById(AuthConstants.ROLE_CACHE_PREFIX + roleId);
            roleSession.set(AuthConstants.PERMISSION_CACHE_KEY, permissionMap.get(roleId));
        }
    }
}
