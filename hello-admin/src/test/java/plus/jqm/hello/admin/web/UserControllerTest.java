package plus.jqm.hello.admin.web;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import plus.jqm.hello.admin.domain.UserDO;
import plus.jqm.hello.admin.domain.vo.UserVO;
import plus.jqm.hello.admin.service.UserService;
import plus.jqm.hello.common.core.constant.StatusConstants;
import plus.jqm.hello.common.core.util.R;

/**
 * UserController 测试类
 *
 * @author xjq
 * @date 2024/04/17
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class UserControllerTest {
    @Autowired
    private WebTestClient webClient;
    @MockBean
    private UserService userService;
    @Autowired
    private JacksonTester<R<UserVO>> json;

    @BeforeEach
    public void setUp() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setUsername("admin");
        userDO.setPassword("123456");
        Mockito.when(this.userService.getById(1L))
               .thenReturn(userDO);
        Mockito.when(this.userService.getById(2L))
               .thenReturn(null);
        Mockito.when(this.userService.getById(3L))
               .thenThrow(new RuntimeException("你不能看"));
    }

    @Test
    @SneakyThrows
    void testGetUserById() {
        R<UserVO> r = getResult("/user/1");
        Assertions.assertThat(r.getStatus()).isEqualTo(StatusConstants.OK);
        Assertions.assertThat(r.getData().getId()).isEqualTo(1L);
        Assertions.assertThat(r.getData().getUsername()).isEqualTo("admin");
        Assertions.assertThat(r.getData().getPassword()).isEqualTo("123456");

        r = getResult("/user/2");
        Assertions.assertThat(r.getStatus()).isEqualTo(StatusConstants.OK);
        Assertions.assertThat(r.getData()).isNull();

        r = getResult("/user/3");
        Assertions.assertThat(r.getStatus()).isEqualTo(StatusConstants.SYSTEM_EXECUTION_ERROR);
        Assertions.assertThat(r.getData()).isNull();
    }

    @SneakyThrows
    private R<UserVO> getResult(String uri) {
        String result = this.webClient
                .get().uri(uri)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult().getResponseBody();
        Assertions.assertThat(result).isNotNull();
        return this.json.parseObject(result);
    }
}
