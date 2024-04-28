package plus.jqm.hello.gateway.handler;

import org.springframework.web.server.ServerWebExchange;

/**
 * 异常处理接口
 *
 * @author xjq
 * @date 2024/04/24
 */
public interface HelloExceptionHandler {
    boolean support(Throwable throwable);

    Object handle(ServerWebExchange exchange, Throwable throwable);
}
