package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();   //동시성 이슈 있으므로 실무에선 ConcurrentHashMap이용
    
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);  //store라는 map에 put(key,value)
        //System.out.println(store.get(member.getId()));
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
