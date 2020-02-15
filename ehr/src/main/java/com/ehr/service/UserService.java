package com.ehr.service;

import com.ehr.model.LoginHistory;
import com.ehr.model.Role;
import com.ehr.model.User;
import com.ehr.repository.LoginHistoryRepository;
import com.ehr.repository.RoleRepository;
import com.ehr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private LoginHistoryRepository historyRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       LoginHistoryRepository historyRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.historyRepository = historyRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    
    public LoginHistory findLoginHistoryByUserId(int userId) {
    	return historyRepository.findByUserId(userId);
    }
    
    public void saveLoginHistory(User user) {
    	LoginHistory history = new LoginHistory();
    	System.out.println("name"+ user.getName()+"user Id"+user.getId());
    	history.setUserId(user.getId());
    	history.setLastLogin(new Date().toString());
    	historyRepository.save(history);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

}
