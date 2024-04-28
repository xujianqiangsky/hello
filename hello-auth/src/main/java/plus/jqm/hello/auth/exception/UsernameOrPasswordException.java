package plus.jqm.hello.auth.exception;

/**
 * 用户名或密码异常
 *
 * @author xjq
 * @date 2024/04/28
 */
public class UsernameOrPasswordException extends RuntimeException {
    public UsernameOrPasswordException(String message) {
        super(message);
    }

    public UsernameOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
