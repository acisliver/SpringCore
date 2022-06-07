package inflearn.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {    // 단점: 스프링 전용 인터페이스에 의존. 거의 사용 X

    private String url;

    public NetworkClient() {
        System.out.println("생성자를 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + ", message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    // 의존관계 주입이 끝나면 호출
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

    // 빈 종료 시 호출
    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
