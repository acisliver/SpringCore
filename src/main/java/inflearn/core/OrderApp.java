package inflearn.core;

import inflearn.core.member.Grade;
import inflearn.core.member.Member;
import inflearn.core.member.MemberService;
import inflearn.core.member.MemberServiceImpl;
import inflearn.core.order.OrderService;
import inflearn.core.order.Order;
import inflearn.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService service = new MemberServiceImpl();
        OrderService oderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        service.join(member);

        Order order = oderService.createOrder(memberId, "itemA", 10000);


        System.out.println("order = " + order);
    }
}
