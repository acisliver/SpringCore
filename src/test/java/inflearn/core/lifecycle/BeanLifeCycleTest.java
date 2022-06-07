package inflearn.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); // 보통 close할 일이 없기 때문에 이 메서드는 기본 ApplicationContext에는 정의되어있지 않다
    }

    @Configuration
    static class LifeCycleConfig {

        // destroyMethod는 대부분 close나 shutdown이다.
        // 그래서 기본값이 (inferred) 추론이다.
        // 자동으로 종료 메서드를 추론해서 호출해준다
        // destroyMethod를 적지 않아도 동작한다.
        // 일부러 사용하지 않을 경우 빈 문자열을 넣어주면 된다.
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://inflearn-core.dev");
            return networkClient;
        }
    }
}
