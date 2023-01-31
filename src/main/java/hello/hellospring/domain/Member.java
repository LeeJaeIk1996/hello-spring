package hello.hellospring.domain;
// 도메인 -> 비즈니스 도메인 객체
// 회원객체 - 1. 아이디, 2. 이름 두 개의 데이터를 갖고 있음.
public class Member {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
