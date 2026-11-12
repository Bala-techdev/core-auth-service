package com.secureauth.secure_auth_platform.repository;

import com.secureauth.secure_auth_platform.entity.RefreshToken;
import com.secureauth.secure_auth_platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    int deleteByUser(User user);
}