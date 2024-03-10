package lk.intelleon.organizerbackend.service.impl;

import lk.intelleon.organizerbackend.entity.User;
import lk.intelleon.organizerbackend.repository.UserRepository;
import lk.intelleon.organizerbackend.service.JwtService;
import lk.intelleon.organizerbackend.service.UserService;
import lk.intelleon.organizerbackend.utility.AuthenticationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Sasindu Malshan
 * @project organizer-backend
 * @date 3/10/2024
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(User request) {

        // check if user already exist. if exist than authenticate the user
        if (repository.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setStatus(request.getStatus());

        user = repository.save(user);

        String jwt = jwtService.generateToken(user);

        return new AuthenticationResponse(jwt, "User registration was successful");

    }

    public AuthenticationResponse authenticate(User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        String jwt = jwtService.generateToken(repository.findByUsername(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));

        return new AuthenticationResponse(jwt, "User login was successful");

    }
}
