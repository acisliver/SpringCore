package inflearn.core.singelton;

import inflearn.core.AppConfig;
import inflearn.core.member.MemberRepository;
import inflearn.core.member.MemberServiceImpl;
import inflearn.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("orderService  -> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        // 순수 클래스라면 class inflearn.core.AppConfig
        // 하지만 내가 만든 순수 클래스가 아니다
        // 바이트코드 조작 라이브러리를 사용해 다른 클래스를 빈으로 등록
        // CGLIB으로 조작된 코드는 싱글턴이 보장될 것이다
        // @Configuration을 사용하지 않으면 빈은 등록이 되지만 싱글턴을 유지하지 못한다.
        // DI도 되지 않고 new를 계속 한다.
        System.out.println("bean = " + bean.getClass());
    }
}
