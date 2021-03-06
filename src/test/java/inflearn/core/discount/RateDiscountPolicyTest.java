package inflearn.core.discount;

import inflearn.core.AppConfig;
import inflearn.core.member.Grade;
import inflearn.core.member.Member;
import inflearn.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    RateDiscountPolicy discountPolicy = ac.getBean("discountPolicy", RateDiscountPolicy.class);

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void discount() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니라면 할인이 적용되지 않아야 한다")
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}