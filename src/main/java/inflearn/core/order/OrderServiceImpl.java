package inflearn.core.order;

import inflearn.core.discount.DiscountPolicy;
import inflearn.core.discount.FixDiscountPolicy;
import inflearn.core.discount.RateDiscountPolicy;
import inflearn.core.member.Member;
import inflearn.core.member.MemberRepository;
import inflearn.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 인터페이스뿐만 아니라 구현 클래스도 의존하고 있다. -> DIP, OCP 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
