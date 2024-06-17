package com.project.cafe.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Notice extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long no_cd;

    @Column(length = 20,nullable = false)
    private String no_title;

    @Column(length = 500, nullable = false)
    private String no_content;

    @Column(length = 20, nullable = false)
    private String no_writer;
    // 등록시간,
    // 수정시간, 많은 테이블에서 공통적으로 사용하니, 인터페이스로 분리해서 재사용할 예정.

    public void changeTitleAndContent(String no_title, String content) {
        this.no_title = no_title;
        this.no_content = content;
    }

}