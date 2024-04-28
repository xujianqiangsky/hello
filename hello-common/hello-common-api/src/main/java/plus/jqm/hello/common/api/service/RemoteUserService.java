package plus.jqm.hello.common.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import plus.jqm.hello.common.api.domain.SysUserDetailsDO;
import plus.jqm.hello.common.core.util.R;
import plus.jqm.hello.common.http.service.annotation.HelloHttpServiceClient;
import plus.jqm.hello.common.sa.token.interceptor.SameTokenClientHttpRequestInterceptor;

/**
 * 用户服务
 *
 * @author xjq
 * @date 2024/04/26
 */
@HelloHttpServiceClient(name = "hello-system", path = "/admin/user", interceptors = SameTokenClientHttpRequestInterceptor.class)
public interface RemoteUserService {
    @GetExchange("/detail/{username}")
    R<SysUserDetailsDO> getUserDetailsByUsername(@PathVariable String username);
}
