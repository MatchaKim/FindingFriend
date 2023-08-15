package com.chaochao.FindingFriend.controller;


import com.chaochao.FindingFriend.dto.SignUpRequest;
import com.chaochao.FindingFriend.service.UsersService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UsersService usersService;

    @GetMapping("/find/{school}")
    public ResponseEntity<?> findUser(@PathVariable String school, Authentication authentication){

      return usersService.findAlumni(school,authentication);

    }

    @GetMapping("/myinfo")
    public ResponseEntity<?> findUser(Authentication authentication){

        return usersService.findMyInfo(authentication);
    }


}
