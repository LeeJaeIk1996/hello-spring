package hello.hellospring.service;


import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach     // 여긴 다시보기; 뭐라는지 모르겠다.
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);

    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given - 어떠한 상황이 주어졌을 때
        Member member = new Member();
        member.setName("spring");

        //when - 이걸 실행했을 때
        Long saveId = memberService.join(member);


        //then - 결과가 이게 나와야 돼!
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    // 테스트의 핵심은 정상 플로우가 아니라 예외 플로우이다.
    // 즉 중복 회원 검증을 통해 중복이 되는지에 관한 예외 상황을 파악해야 된다.
    @Test
    public void 중복_회원_예외() {
       //given
       Member member1 = new Member();
       member1.setName("spring");

       Member member2 = new Member();
       member2.setName("spring");

       //when
       memberService.join(member1);
       /*
       try {
           memberService.join(member2);
           fail();
       } catch (IllegalStateException e) {
           assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
       }
        */
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}