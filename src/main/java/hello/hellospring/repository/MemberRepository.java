// 리포지토리 -> 회원 객체를 저장하는 저장소
package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);     // 회원이 저장소에 저장됨
    // 저장소에 findById나 findByNmae으로 찾아올 수 있음.
    Optional<Member> findById(Long id); // 저장소에서 id로 회원을 찾을 수 있도록.
    Optional<Member> findByName(String name);   // 저장소에서 이름으로 회원을 찾을 수 있도록.
    List<Member> findAll(); // findAll -> 지금까지 저장된 모든 회원 리스트를 반환
}
