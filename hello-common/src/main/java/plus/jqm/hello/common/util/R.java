package plus.jqm.hello.common.util;

import lombok.Getter;
import lombok.Setter;
import plus.jqm.hello.common.constant.StatusConstants;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一返回结果
 *
 * @author xjq
 * @date 2024/04/16
 */
@Setter
@Getter
public final class R<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 响应状态码
     */
    private String status;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    private R() {}

    public static <T> R<T> ok() {
        return build(StatusConstants.OK, MessageSourceUtils.getMessage("ok"), null);
    }

    public static <T> R<T> ok(T data) {
        return build(StatusConstants.OK, MessageSourceUtils.getMessage("ok"), data);
    }

    public static <T> R<T> build(String status, String message, T data) {
        R<T> r = new R<>();
        r.status = status;
        r.message = message;
        r.data = data;
        return r;
    }
}
