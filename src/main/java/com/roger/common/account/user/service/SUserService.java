package com.roger.common.account.user.service;

import com.roger.common.account.user.domain.SUser;
import com.roger.common.account.user.repository.SUserRepository;
import com.roger.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SUserService {
    @Autowired
    private SUserRepository sUserRepository;

    public SUser getUserByLoingName(String loginName){
        Constant.test="测试";
        SUser sUser = sUserRepository.findByLoginname(loginName);
        return sUser;
    }
}
