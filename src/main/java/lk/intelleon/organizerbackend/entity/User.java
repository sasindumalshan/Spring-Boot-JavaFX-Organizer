package lk.intelleon.organizerbackend.entity;

import jakarta.persistence.*;
import lk.intelleon.organizerbackend.entity.enumretion.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Sasindu Malshan
 * @project organizer-backend
 * @date 3/10/2024
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Entity
@Table(name = "tbl_master_user")
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", columnDefinition = "VARCHAR(64)", nullable = false)
    private String username;
    @Column(name = "password", columnDefinition = "VARCHAR(64)", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
