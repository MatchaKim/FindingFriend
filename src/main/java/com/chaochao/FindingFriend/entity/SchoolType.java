package com.chaochao.FindingFriend.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SchoolType {

    @Id
    @GeneratedValue
    @Column(name = "schooltypeid")
    private Integer id;

    @Column(unique = true)
    private String schooltype;

    @OneToMany(mappedBy = "schooltype")
    private List<School> schoollist;


}
