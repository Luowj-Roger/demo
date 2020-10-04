package com.hnisi.common.account.user.repository;

import com.hnisi.common.account.user.domain.SUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SUserRepository extends JpaRepository<SUser, String> {
    public SUser findByLoginname(String loginNme);
}
