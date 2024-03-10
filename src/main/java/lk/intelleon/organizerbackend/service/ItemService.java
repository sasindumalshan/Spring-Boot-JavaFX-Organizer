package lk.intelleon.organizerbackend.service;

import lk.intelleon.organizerbackend.dto.ItemDTO;
import lk.intelleon.organizerbackend.entity.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/5/2024
 */

public interface ItemService {
    void save(ItemDTO itemDTO);

    void update(ItemDTO itemDTO);

    ResponseEntity<Item> remove(Long id);

    ItemDTO findItem(Long id);

    List<ItemDTO> findAllItem();

    List<ItemDTO> findAllItemLikeIdAndName(String id);

    Long countByAll();

    boolean isExitsByCategory(Long id);


}
