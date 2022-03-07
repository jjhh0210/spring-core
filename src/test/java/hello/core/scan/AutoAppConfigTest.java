package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean("memberServiceImpl",MemberService.class);  //빈이름 주의
        OrderService orderService = ac.getBean(OrderService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);
    }
}
