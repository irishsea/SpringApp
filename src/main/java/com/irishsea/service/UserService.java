package com.irishsea.service;

import com.irishsea.entity.Role;
import com.irishsea.entity.User;
import com.irishsea.repository.RoleRepository;
import com.irishsea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } else return user;
    }

    public boolean saveUser(User user) {
        User userFromStorage = userRepository.findByUsername(user.getUsername());
        if (userFromStorage != null) {
            return false;
        }
        user.setRoles(Set.of(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setPassword(user.getPassword());
        userRepository.save(user);
        return true;
    }

    public Optional<User> findUserById(Long userId) {
        Optional<User> userFromStorage = userRepository.findById(userId);
        return userFromStorage;
    }

    public List<User> allUsers() {
        return (List<User>) userRepository.findAll();
    }


}
