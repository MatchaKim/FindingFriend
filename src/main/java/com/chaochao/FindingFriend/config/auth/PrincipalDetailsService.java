package com.chaochao.FindingFriend.config.auth;


import com.chaochao.FindingFriend.entity.Users;
import com.chaochao.FindingFriend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userEntity = userRepository.findByPhonenumber(username).orElse(null);
        //     System.out.println("1111");
        return new PrincipalDetails(userEntity);

        /*username 으로 받는게 디폴트인데 나는 폰넘버로 받겠다*/
    }
}
