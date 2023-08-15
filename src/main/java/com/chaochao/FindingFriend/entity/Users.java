package com.chaochao.FindingFriend.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String phonenumber;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String elementaryschool;
    @Column(nullable = false)
    private String middleschool;
    @Column(nullable = false)
    private String highschool;


    private String introduction;
    @Column(nullable = false)
    private Integer graduationyear;

    @Column(nullable = false)
    private String roles; // USER, ADMIN


    public List<String> getRoleList(){
        if (this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    @Builder
    public Users(Integer id, String username, String phonenumber, String password, String elementaryschool, String middleschool, String highschool, String introduction, Integer graduationyear, String roles) {
        this.id = id;
        this.username = username;
        this.phonenumber = phonenumber;
        this.password = password;
        this.elementaryschool = elementaryschool;
        this.middleschool = middleschool;
        this.highschool = highschool;
        this.introduction = introduction;
        this.graduationyear = graduationyear;
        this.roles = roles;
    }
}
