package inflearn.core.order;

import inflearn.core.discount.DiscountPolicy;
import inflearn.core.discount.FixDiscountPolicy;
import inflearn.core.member.Member;
import inflearn.core.member.MemberRepository;
import inflearn.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
