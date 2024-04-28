package plus.jqm.hello.common.sa.token.config;

import cn.dev33.satoken.same.SaSameUtil;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Same-Token 定时刷新
 *
 * @author xjq
 * @date 2024/04/28
 */
public class SaSameTokenRefreshTask {
    // 从 0 分钟开始 每隔 5 分钟执行一次 Same-Token
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void refreshToken(){
        SaSameUtil.refreshToken();
    }
}
