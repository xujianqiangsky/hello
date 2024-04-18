package plus.jqm.hello.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * MessageSource 工具类 (需配合 @EnableSpringUtils 使用)
 *
 * @author xjq
 * @date 2024/04/16
 */
@Slf4j
public class MessageSourceUtils {
    private static final MessageSource messageSource;

    static {
        messageSource = SpringUtils.getBean(MessageSource.class);
    }

    private MessageSourceUtils() {}

    public static String getMessage(String code, Object... args) {
        try {
            return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            log.warn("no such message: {}", e.getMessage());
        }
        return code;
    }
}
