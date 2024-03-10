package lk.intelleon.organizerbackend.controller;

import lk.intelleon.organizerbackend.entity.User;
import lk.intelleon.organizerbackend.service.UserService;
import lk.intelleon.organizerbackend.utility.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sasindu Malshan
 * @project organizer-backend
 * @date 3/10/2024
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User user
    ) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User user
    ) {
        return ResponseEntity.ok(userService.authenticate(user));
    }
}
