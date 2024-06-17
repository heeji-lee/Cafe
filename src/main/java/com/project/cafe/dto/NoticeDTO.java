package com.project.cafe.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {

    private Long no_cd;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String no_title;

    @NotEmpty
    private String no_content;

    @NotEmpty
    private String no_writer;

    private LocalDateTime no_regDate;
//    private LocalDateTime modDate;

}
