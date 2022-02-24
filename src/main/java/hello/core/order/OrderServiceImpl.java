package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*주문생성*/
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //1)회원저장소 역할에서 회원 조회
        Member member = memberRepository.findById(memberId);

        //2)할인 적용
        /*단일 체계 원칙을 잘 지킨 이유: OrderService는 discountPolicy에 멤버랑 가격만 넘기고 할인 어떻게 되는지는 알아서 하게함.
        * 즉, 할인에 대한 변경이 필요하면 discountPolicy를 고치면 됨
        * OrderService에서는 할인 관련 변경 필요x!*/
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName,itemPrice, discountPrice);
    }
}
