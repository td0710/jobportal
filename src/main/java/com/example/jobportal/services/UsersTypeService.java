package com.example.jobportal.services;

import com.example.jobportal.entity.UsersType;
import com.example.jobportal.repository.UsersTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAllUsersTypes() {
        return usersTypeRepository.findAll();
    }

}
