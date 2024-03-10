package lk.intelleon.organizerbackend.repository;

import lk.intelleon.organizerbackend.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/4/2024
 */
public interface SupplierRepo extends JpaRepository<Supplier, Long> {
    @Query(value = "SELECT * FROM tbl_master_suppliers WHERE id LIKE ? OR name LIKE ?", nativeQuery = true)
    List<Supplier> findAllUnitLikeIdAndName(String id, String name);

}
