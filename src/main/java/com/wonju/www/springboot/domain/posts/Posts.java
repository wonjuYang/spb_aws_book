package com.wonju.www.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //이 클래스가 테이블과 링크됨을 나타냄
public class Posts {

    @Id //이게 해당 테이블의 PK이다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙, GenerationType.IDENTITY => auto increment
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼이다. 기본값 외에 추가로 변경이 필요한 옵션이 있어서 사용 VARCHAR2(255)가 기본인데 VARCHAR2(500)을 쓰겠다는 내용
    private String title;

    @Column(columnDefinition = "TEXT", nullable= false) //VARCHAR2가 아닌 TEXT를 쓰겠다
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author ){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
