package inflearn.core.xml;

import inflearn.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        GenericXmlApplicationContext xa = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = xa.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
