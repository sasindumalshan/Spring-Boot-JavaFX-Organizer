package lk.intelleon.organizerbackend.repository;

import lk.intelleon.organizerbackend.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/4/2024
 */
public interface UnitRepo extends JpaRepository<Unit, Long> {
    @Query(value = "SELECT * FROM tbl_master_unit WHERE id LIKE ? OR name LIKE ?", nativeQuery = true)
    List<Unit> findAllUnitLikeIdAndName(String id, String name);

}
