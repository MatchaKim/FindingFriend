package com.chaochao.FindingFriend.controller;

import com.chaochao.FindingFriend.dto.SignUpRequest;
import com.chaochao.FindingFriend.entity.SchoolType;
import com.chaochao.FindingFriend.entity.SchoolTypeEnum;
import com.chaochao.FindingFriend.repository.SchoolTypeRepository;
import com.chaochao.FindingFriend.service.ElementarySaveService;
import com.chaochao.FindingFriend.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class EntryController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ElementarySaveService elementarySaveService;
    private final UsersService usersService;

    private final SchoolTypeRepository schoolTypeRepository;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpRequest signUpRequest) {
        return usersService.signUp(signUpRequest);
    }

    @Autowired
    public void getSchools(){

        SchoolType schoolType = new SchoolType();
        schoolType.setSchooltype(SchoolTypeEnum.ELEMENTARY.name());
        schoolTypeRepository.save(schoolType);
        schoolType.setSchooltype(SchoolTypeEnum.MIDDLE.name());
        schoolTypeRepository.save(schoolType);
        schoolType.setSchooltype(SchoolTypeEnum.HIGH.name());
        schoolTypeRepository.save(schoolType);


        elementarySaveService.getSchool();


    }

    @PostMapping("/data")
    public void setData() {

        List<String> firstname = Arrays.asList("김", "이", "박", "최", "윤", "송");
        List<String> middlename = Arrays.asList("정", "영", "준", "승", "지", "송");
        List<String> lastname = Arrays.asList("호", "진", "영", "준", "학", "민", "명");

        List<String> elementary = Arrays.asList("세류초등학교", "먹부림초등학교", "세곡초등학교");
        List<String> middle = Arrays.asList("수원중학교", "인덕원중학교", "죽전중학교", "곡선중", "매탄중");
        List<String> high = Arrays.asList("수원고등학교", "권선고등학교", "매현고등학교", "라면고등학교");
        List<String> info = Arrays.asList("나 기억하니?", "나 기억나면 연락해"
                , "친구들 보고싶다.", "얘들아 보고싶다", "세류초등학교 모여라!", "바둑둘사람 연락해!", "찾아라 비밀의 열쇠", "춤추는 고무신~~", "바쿠간 슛"
                , "누진스 요즘좋아하는사람?", "얘들아 뭐하지내니?");


        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            String randomelementary = elementary.get(random.nextInt(elementary.size()));
            String randommiddle = middle.get(random.nextInt(elementary.size()));
            String randomhigh = high.get(random.nextInt(elementary.size()));

            int firstPart = random.nextInt(1000);
            int secondPart = random.nextInt(10000);
            int thirdPart = random.nextInt(10000);

            String phoneNumber = String.format("010-%04d-%04d", firstPart, secondPart, thirdPart);
            int randomYear = 2017 + random.nextInt(4);


            SignUpRequest signUpRequests = new SignUpRequest();
            signUpRequests.setUsername(firstname.get((int) (Math.random() * firstname.size())) + middlename.get((int) (Math.random() * firstname.size())) + lastname.get((int) (Math.random() * firstname.size())));
            signUpRequests.setIntroduction(info.get(random.nextInt(info.size())));
            signUpRequests.setElementaryschool(randomelementary);
            signUpRequests.setMiddleschool(randommiddle);
            signUpRequests.setHighschool(randomhigh);
            signUpRequests.setPhonenumber(phoneNumber);
            signUpRequests.setPassword("1234");
            signUpRequests.setGraduationyear(Integer.toString(randomYear));
            usersService.signUp(signUpRequests);
        }
    }
}
