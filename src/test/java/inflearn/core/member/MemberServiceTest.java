package inflearn.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService service = new MemberServiceImpl();

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
