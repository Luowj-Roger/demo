package com.hnisi.security.authentication.userdetails;

import com.hnisi.account.user.domain.SUser;
import com.hnisi.account.user.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SGUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SUserService sUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里需要去数据库查询用户的账号密码来比对是否正确，以及账号是否过期等等
        //String password = passwordEncoder.encode("123456");
        SUser sUser =  sUserService.getUserByLoingName(username);
        String password = "123";
        password = sUser.getPassword();
        return new User(username, password,
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
