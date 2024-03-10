package lk.intelleon.organizerbackend.service;

import lk.intelleon.organizerbackend.dto.CategoryDTO;
import lk.intelleon.organizerbackend.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/4/2024
 */

public interface CategoryService {
    void save(CategoryDTO categoryDTO);

    void update(CategoryDTO categoryDTO);

    ResponseEntity<Category> remove(Long id);

    CategoryDTO findUnit(Long id);

    List<CategoryDTO> findAllUnit();

    List<CategoryDTO> findAllUnitLikeIdAndName(String id);

    Long countByAll();
}
