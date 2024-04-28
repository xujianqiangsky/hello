package plus.jqm.hello.common.sa.token.interceptor;

import cn.dev33.satoken.same.SaSameUtil;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 使用 Same-Token 模块提供的身份校验能力，完成服务间的权限认证
 *
 * @author xjq
 * @date 2024/04/27
 */
public class SameTokenClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add(SaSameUtil.SAME_TOKEN, SaSameUtil.getToken());
        return execution.execute(request, body);
    }
}
