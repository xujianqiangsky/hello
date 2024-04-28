package plus.jqm.hello.common.core.constant;

/**
 * 响应状态
 *
 * @author xjq
 * @date 2024/04/16
 */
public final class StatusConstants {
    private StatusConstants() {}

    public static final String OK = "00000";

    public static final String SYSTEM_EXECUTION_ERROR = "B0001";
    public static final String SYSTEM_RESOURCE_NOT_FOUND = "B0100";

    public static final String USER_ERROR = "A0001";
    public static final String USER_LOGIN_FAILURE = "A0120";
    public static final String USER_ACCESS_UNAUTHORIZED = "A0301";
    public static final String USER_ACCESS_DENIED = "A0320";
    public static final String USER_ACCESS_ILLEGAL = "A0342";
}
