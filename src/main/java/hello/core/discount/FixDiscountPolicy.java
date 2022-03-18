package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int disCountFixAmount = 1000;   //할인 금액 = 1000원

    @Override
    public int discount(Member member, int price) {
        //VIP고객이면 할인금액은 1000원, 아니면 없어!
        if(member.getGrade()== Grade.VIP){
            return disCountFixAmount;
        }else{
            return 0;
        }
    }
}
