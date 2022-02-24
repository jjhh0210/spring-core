package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;    //이제 추상화만 의존함! 구체적인 클래스 뭐가 지정될지 전혀 모름 ->DIP 지킴

    //생성자 주입 - 밖에서 구체적 구현체를 지정,선택해줌
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
