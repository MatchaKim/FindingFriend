package com.chaochao.FindingFriend.repository;

import com.chaochao.FindingFriend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findAllByElementaryschoolAndGraduationyear(String middleschool, Integer graduationyear);

    List<Users> findAllByMiddleschoolAndGraduationyear(String middleschool, Integer graduationyear);
    List<Users> findAllByHighschoolAndGraduationyear(String middleschool, Integer graduationyear);
    Optional<Users> findByUsername(String username);
    Optional<Users> findByPhonenumber(String phonenumber);
}
