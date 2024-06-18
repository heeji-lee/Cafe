package com.project.cafe.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notice extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long cd;

    @Column(length = 20,nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(length = 20, nullable = false)
    private String writer;
    // 등록시간,
    // 수정시간, 많은 테이블에서 공통적으로 사용하니, 인터페이스로 분리해서 재사용할 예정.

//    public void changeTitleAndContent(String no_title, String no_content) {
//        this.no_title = no_title;
//        this.no_content = no_content;
//    }

}