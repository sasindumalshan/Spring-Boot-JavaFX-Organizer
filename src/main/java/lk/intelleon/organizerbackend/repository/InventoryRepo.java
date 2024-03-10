package lk.intelleon.organizerbackend.repository;

import lk.intelleon.organizerbackend.entity.Inventory;
import lk.intelleon.organizerbackend.entity.Item;
import lk.intelleon.organizerbackend.projection.InventoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/5/2024
 */

public interface InventoryRepo extends JpaRepository<Inventory, Long> {

    @Query(value = "SELECT * FROM tbl_master_inventory WHERE id LIKE ? OR item LIKE  ?", nativeQuery = true)
    List<Item> findAllUnitLikeIdAndName(String id, String name);

    @Query(value = "SELECT i.id AS id ,i.received_qty AS QTY , it.name AS itemName, i.expire_date AS expireDate ,c.name AS categoryName FROM tbl_master_inventory i INNER JOIN tbl_master_item it ON i.item = it.id INNER JOIN tbl_master_category c ON it.category = c.id WHERE expire_date <= DATE_ADD(CURDATE(), INTERVAL 10 DAY)", nativeQuery = true)
    List<InventoryProjection> getPendingToExpireItems();

    boolean existsByItem_Id(Long id);
}
