package com.example.jobportal.repository;

import com.example.jobportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepoistory extends JpaRepository<Users, Integer> {
}
