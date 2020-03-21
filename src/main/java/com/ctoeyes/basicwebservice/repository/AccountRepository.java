package com.ctoeyes.basicwebservice.repository;

import com.ctoeyes.basicwebservice.pojo.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    AccountEntity findByAccountName (String accountName);
}
