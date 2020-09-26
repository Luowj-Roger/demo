package com.hnisi.account.user.repository;

import com.hnisi.account.user.domain.SUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;


public interface SUserRepository extends JpaRepository<SUser, String> {
    public SUser findByLoginname(String loginNme);
}
