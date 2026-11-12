package com.secureauth.secure_auth_platform.repository;

import com.secureauth.secure_auth_platform.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    List<LoginHistory> findByEmailOrderByLoginTimeDesc(String email);
}