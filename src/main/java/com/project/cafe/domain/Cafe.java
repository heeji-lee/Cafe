package com.project.cafe.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cafe extends BaseEntity {
    private String userId;
    private String password;
    private String gender;
    private String phone;
    private String birthday;

}
