package com.chaochao.FindingFriend.service;

import com.chaochao.FindingFriend.entity.School;
import com.chaochao.FindingFriend.entity.SchoolType;
import com.chaochao.FindingFriend.entity.SchoolTypeEnum;
import com.chaochao.FindingFriend.repository.SchoolRepository;
import com.chaochao.FindingFriend.repository.SchoolTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ElementarySaveService {
    private final SchoolRepository schoolRepository;


    public void getSchool(){
        List<String> elementarys = Arrays.asList();

    SchoolType schoolType = new SchoolType();

    for(int i=0;i< elementarys.size();i++){
        School insertschool =new School();
//        insertschool.setSchooltype(schoolType.setSchooltype(SchoolTypeEnum.ELEMENTARY.name()));
//        schoolRepository.save(insertschool.setName(elementarys.get(i)));
    }

    }
}
