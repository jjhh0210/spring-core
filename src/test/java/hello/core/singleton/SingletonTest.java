package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너 - 여러번 호출시 매번 다른 객체 사용")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 호출할 때마다 객체를 생성하는지 조회
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        //2. 참조값이 다른지 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //3. memberservice1 != memberSertive2 테스트
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        //new SingletonService로 객체 생성 불가! only getInstance()로만 가능
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        Assertions.assertThat(instance1).isSameAs(instance2);
        //same : ==인지를 비교
        //equal :
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤 - 여러번 호출 해도 같은 객체를 사용")
    void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 같은지 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberservice1 == memberSertive2 테스트
        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }
}
