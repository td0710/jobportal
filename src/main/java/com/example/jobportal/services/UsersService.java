package com.example.jobportal.services;

import com.example.jobportal.entity.JobSeekerProfile;
import com.example.jobportal.entity.RecruiterProfile;
import com.example.jobportal.entity.Users;
import com.example.jobportal.repository.JobSeekerProfileRepository;
import com.example.jobportal.repository.RecruiterProfileRepository;
import com.example.jobportal.repository.UsersRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepoistory usersRepoistory;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    @Autowired
    public UsersService(UsersRepoistory usersRepoistory,JobSeekerProfileRepository jobSeekerProfileRepository,RecruiterProfileRepository recruiterProfileRepository) {
        this.usersRepoistory = usersRepoistory;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNew(Users user) {
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        int userTypeId = user.getUserTypeId().getUserTypeId();
        Users savedUser = usersRepoistory.save(user) ;
        if (userTypeId==1){
             recruiterProfileRepository.save(new RecruiterProfile(user));
        }
        else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(user));
        }
        return savedUser;
    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepoistory.findByEmail(email);
    }
}
