package lk.intelleon.organizerbackend.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AuthenticationResponse {
    private String token;
    private String message;

}
