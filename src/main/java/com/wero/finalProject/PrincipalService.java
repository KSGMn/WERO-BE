package com.wero.finalProject;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @작성자:
 * @작성날짜:
 * @파일명:
 **/
@Service
@RequiredArgsConstructor
public class PrincipalService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadByUserByUsername(String username) throws UsernameNotFoundException{
        User findUser = userRepository.findByUsername(username);
        if(findUser!=null){
            return new PrincipalDetails(findUser);
        }
        return null;
    }
}
