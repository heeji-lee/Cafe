package com.project.cafe.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CafeDTO {
    @NotEmpty
    @Size(min = 3, max = 10)
    private String userId;
    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String birthday;


}
