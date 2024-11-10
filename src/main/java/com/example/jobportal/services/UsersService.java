package com.example.jobportal.services;

import com.example.jobportal.entity.Users;
import com.example.jobportal.repository.UsersRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Service
public class UsersService {
    private final UsersRepoistory usersRepoistory;

    @Autowired
    public UsersService(UsersRepoistory usersRepoistory) {
        this.usersRepoistory = usersRepoistory;
    }

    public Users addNew(Users user) {
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        return usersRepoistory.save(user);
    }

}
