package inflearn.core.discount;

import inflearn.core.member.Grade;
import inflearn.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixMount = 1000;

    @Override
    public int discount(Member member, int price) {
            if (member.getGrade() == Grade.VIP) {
                return discountFixMount;
            } else {
                return 0;
            }
    }
}
