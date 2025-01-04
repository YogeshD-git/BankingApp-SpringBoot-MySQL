package com.yogeshspringproject.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yogeshspringproject.banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
