package inflearn.core.member;

import inflearn.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService service = ac.getBean("memberService", MemberService.class);

    @Test
    void join() {
        // given
        Member member = new Member(1L, "A", Grade.VIP);

        // when
        service.join(member);
        Member findMember = service.findMember(1L);

        // then
        assertThat(member).isEqualTo(findMember);
    }
}
