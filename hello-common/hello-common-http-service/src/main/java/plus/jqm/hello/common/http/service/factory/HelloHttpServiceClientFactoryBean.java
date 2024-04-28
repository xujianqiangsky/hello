package plus.jqm.hello.common.http.service.factory;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * HelloHttpServiceClient 工厂
 *
 * @author xjq
 * @date 2024/04/27
 */
@Slf4j
public class HelloHttpServiceClientFactoryBean implements FactoryBean<Object>, InitializingBean, ApplicationContextAware, BeanFactoryAware {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    private String path;

    @Getter
    @Setter
    private Class<?> type;

    @Getter
    @Setter
    private Class<?>[] interceptors;

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    public HelloHttpServiceClientFactoryBean() {
        if (log.isDebugEnabled()) {
            log.debug("Creating a HelloHttpServiceClientFactoryBean.");
        }
    }

    @Override
    public Object getObject() throws Exception {
        RestClient.Builder builder = beanFactory != null ? beanFactory.getBean(RestClient.Builder.class)
                : applicationContext.getBean(RestClient.Builder.class);
        if (!StringUtils.hasText(url)) {
            if (log.isInfoEnabled()) {
                log.info("For '" + name + "' URL not provided. Will try picking an instance via load-balancing.");
            }
            if (!name.startsWith("http://") && !name.startsWith("https://")) {
                url = "http://" + name;
            } else {
                url = name;
            }
            url += cleanPath();
        }
        customize(builder);
        RestClient restClient = builder.baseUrl(url).build();
        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return factory.createClient(this.type);
    }

    private void customize(RestClient.Builder builder) throws Exception {
        for (Class<?> clazz : interceptors) {
            Object interceptor = clazz.getDeclaredConstructor().newInstance();
            if (interceptor instanceof ClientHttpRequestInterceptor clientHttpRequestInterceptor) {
                builder.requestInterceptor(clientHttpRequestInterceptor);
            }
        }
    }

    private String cleanPath() {
        if (path == null) {
            return "";
        }
        String path = this.path.trim();
        if (StringUtils.hasLength(path)) {
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
        }
        return path;
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(name, "Name must be set");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
