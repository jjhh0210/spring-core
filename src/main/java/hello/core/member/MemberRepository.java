package hello.core.member;

public interface MemberRepository {
    
    //저장
    void save(Member member);
    
    //id로 회원을 찾아줌
    Member findById(Long memberId);
}
