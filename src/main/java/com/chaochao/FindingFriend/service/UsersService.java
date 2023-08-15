package com.chaochao.FindingFriend.service;

import com.chaochao.FindingFriend.config.auth.PrincipalDetails;
import com.chaochao.FindingFriend.dto.AlumniResponse;
import com.chaochao.FindingFriend.dto.MyInfoResponse;
import com.chaochao.FindingFriend.dto.SignUpRequest;
import com.chaochao.FindingFriend.entity.Users;
import com.chaochao.FindingFriend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;


    @Transactional
    public ResponseEntity signUp(SignUpRequest signUpRequest) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        Users user = Users.builder()
                .roles("ROLE_USER")
                .phonenumber(signUpRequest.getPhonenumber())
                .username(signUpRequest.getUsername())
                .password(encodedPassword)
                .elementaryschool(signUpRequest.getElementaryschool())
                .middleschool(signUpRequest.getMiddleschool())
                .highschool(signUpRequest.getHighschool())
                .introduction(signUpRequest.getIntroduction())
                .graduationyear(Integer.parseInt(signUpRequest.getGraduationyear()))
                .build();


        usersRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> findAlumni(String school, Authentication authentication) {

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        String myschool=null;

        Integer graduationyear= principal.getUser().getGraduationyear();
        List<Users> usersList = new ArrayList<>();
        switch (school) {
            case "elementary":
                myschool = principal.getUser().getElementaryschool();
                usersList = usersRepository.findAllByElementaryschoolAndGraduationyear(myschool,graduationyear);
                break;
            case "middle":
                myschool = principal.getUser().getMiddleschool();
                usersList = usersRepository.findAllByMiddleschoolAndGraduationyear(myschool,graduationyear);
                break;
            case "high":
                myschool = principal.getUser().getHighschool();
                usersList = usersRepository.findAllByHighschoolAndGraduationyear(myschool,graduationyear);
                break;
            default: return ResponseEntity.badRequest().body("School Not Found");
        }
        List<AlumniResponse> alumniResponseList = new ArrayList<>();

        for(Users alumni:usersList){
            alumniResponseList.add(new AlumniResponse(alumni.getUsername(),alumni.getPhonenumber(),alumni.getIntroduction()));
        }

        return ResponseEntity.ok().body(alumniResponseList);

    }

    public ResponseEntity<MyInfoResponse> findMyInfo(Authentication authentication) {

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();

        MyInfoResponse myInfoResponse = new MyInfoResponse();
        myInfoResponse.setUsername(principal.getUsername());
        myInfoResponse.setElementaryschool(principal.getUser().getElementaryschool());
        myInfoResponse.setMiddleschool(principal.getUser().getMiddleschool());
        myInfoResponse.setHighschool(principal.getUser().getHighschool());
        myInfoResponse.setGraduationyear(Integer.toString(principal.getUser().getGraduationyear()));
        return ResponseEntity.ok().body(myInfoResponse);
    }
}
