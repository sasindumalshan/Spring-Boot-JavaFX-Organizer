package lk.intelleon.organizerbackend.repository;

import lk.intelleon.organizerbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Sasindu Malshan
 * @project organizer-backend
 * @date 3/10/2024
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM tbl_master_user WHERE username = :name", nativeQuery = true)
    List<User> findUser(@Param("name") String user_name);

    Optional<User> findByUsername(String userName);
}
