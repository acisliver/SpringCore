package inflearn.core.order;

import inflearn.core.annotation.MainDiscountPolicy;
import inflearn.core.discount.DiscountPolicy;
import inflearn.core.member.Member;
import inflearn.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OrderServiceImpl implements OrderService {

    // 인터페이스뿐만 아니라 구현 클래스도 의존하고 있다. -> DIP, OCP 위반
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    // 생성자가 하나라면 @Autowired가 없어도 final로 선언된 빈을 등록해준다
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
