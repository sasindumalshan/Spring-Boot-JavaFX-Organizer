package lk.intelleon.organizerbackend.repository;

import lk.intelleon.organizerbackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/5/2024
 */

public interface ItemRepo extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM tbl_master_item WHERE id LIKE ? OR name LIKE ?", nativeQuery = true)
    List<Item> findAllUnitLikeIdAndName(String id, String name);

    boolean existsByCategory_Id(Long id);

    boolean existsByUnit_Id(Long id);


}
