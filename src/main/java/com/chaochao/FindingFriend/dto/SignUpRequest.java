package com.chaochao.FindingFriend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
public class SignUpRequest {

    private String username;
    private String phonenumber;
    private String password;
    private String elementaryschool;
    private String middleschool;
    private String highschool;
    private String introduction;
    private String graduationyear;

}
