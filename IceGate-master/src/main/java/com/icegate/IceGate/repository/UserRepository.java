package com.icegate.IceGate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icegate.IceGate.entity.UserEntity;

@Repository("user_repo")
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
