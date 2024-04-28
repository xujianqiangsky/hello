package plus.jqm.hello.common.sa.token.handler;

import cn.dev33.satoken.context.model.SaResponse;

/**
 * SaToken 异常处理器
 *
 * @author xjq
 * @date 2024/04/25
 */
public interface HelloSaTokenExceptionHandler {
    boolean support(Throwable throwable);

    Object handle(SaResponse response, Throwable throwable);
}
