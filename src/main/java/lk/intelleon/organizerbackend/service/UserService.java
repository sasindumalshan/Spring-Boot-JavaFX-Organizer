package lk.intelleon.organizerbackend.service;

import lk.intelleon.organizerbackend.entity.User;
import lk.intelleon.organizerbackend.utility.AuthenticationResponse;

/**
 * @author Sasindu Malshan
 * @project organizer-backend
 * @date 3/10/2024
 */

public interface UserService {
    AuthenticationResponse register(User user);

    AuthenticationResponse authenticate(User user);
}
