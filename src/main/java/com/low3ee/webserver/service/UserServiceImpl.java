package com.low3ee.webserver.service;

import com.low3ee.webserver.dto.CreateUserRequest;
import com.low3ee.webserver.dto.UserResponse;
import com.low3ee.webserver.entity.User;
import com.low3ee.webserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repo;
    private final PasswordEncoder hash;

    @Override
    public UserResponse createUser(CreateUserRequest dto) {
        User user = User.builder()
                .fname(dto.getFname())
                .lname(dto.getLname())
                .email(dto.getEmail())
                .password(hash.encode(dto.getPassword()))
                .build();
        return toDto(repo.save(user));
    }

    @Override
    public UserResponse getUserById( String id){
        return toDto(repo.findById(id).orElseThrow());
    }

    @Override
    public List<UserResponse> getAllUsers(){
        return repo.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(String id, CreateUserRequest dto) {
        User user = repo.findById(id).orElseThrow();

        user.setFname(dto.getFname());
        user.setLname((dto.getLname()));
        user.setEmail(dto.getEmail());
        if(dto.getPassword() != null && !dto.getPassword().isBlank()){
            user.setPassword(hash.encode(dto.getPassword()));
        }
        return toDto(repo.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), List.of()
        );
    }

    public void deleteUser(String id){
        repo.deleteById(id);
    }

    //helper
    private UserResponse toDto(User user){
        return new UserResponse(user.getId(), user.getFname(), user.getLname(), user.getEmail());
    }

}
