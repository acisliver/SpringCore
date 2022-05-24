package inflearn.core;

import inflearn.core.discount.FixDiscountPolicy;
import inflearn.core.member.MemberService;
import inflearn.core.member.MemberServiceImpl;
import inflearn.core.member.MemoryMemberRepository;
import inflearn.core.order.OrderService;
import inflearn.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
