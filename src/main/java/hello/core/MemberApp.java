package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        /*
//         * memberService에는 memberServiceImpl 객체를 받을 것이고,
//         * memberServiceImpl은 MemoryMemberRepository를 의존하고 있을 것
//         * */
//        MemberService memberService = appConfig.memberService();
        //스프링 컨테이너 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링 빈(객체) 찾기
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//(꺼낼메소드 이름, 반환타입)



        //회원 생성
        Member mem = new Member(1L, "A", Grade.VIP);
        //가입
        memberService.join(mem);
        //ID로 회원조회 및 확인
        Member findmem = memberService.findMember(1L);
        System.out.println("mem = " + mem.getName());
        System.out.println("findmem = " + findmem.getName());
    }
}
