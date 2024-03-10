package lk.intelleon.organizerbackend.service;

import io.jsonwebtoken.Claims;
import lk.intelleon.organizerbackend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

/**
 * @author Sasindu Malshan
 * @project organizer-backend
 * @date 3/10/2024
 */

public interface JwtService {

    String extractUsername(String token);

    boolean isValid(String token, UserDetails user);

    <T> T extractClaim(String token, Function<Claims, T> resolver);

    String generateToken(User user);

}
