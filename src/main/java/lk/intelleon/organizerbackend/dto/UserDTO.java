package lk.intelleon.organizerbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/6/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String status;
}
