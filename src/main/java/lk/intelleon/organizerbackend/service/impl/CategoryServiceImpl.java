package lk.intelleon.organizerbackend.service.impl;

import lk.intelleon.organizerbackend.dto.CategoryDTO;
import lk.intelleon.organizerbackend.entity.Category;
import lk.intelleon.organizerbackend.repository.CategoryRepo;
import lk.intelleon.organizerbackend.repository.ItemRepo;
import lk.intelleon.organizerbackend.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/4/2024
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ItemRepo itemRepo;

    @Override
    public void save(CategoryDTO categoryDTO) {
        if (categoryRepo.existsById(Long.valueOf(categoryDTO.getId()))) {
            throw new RuntimeException(categoryDTO.getId() + " This Supplier is Already available");
        }
        categoryRepo.save(mapper.map(categoryDTO, Category.class));
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        if (!categoryRepo.existsById(Long.valueOf(categoryDTO.getId()))) {
            throw new RuntimeException(categoryDTO.getId() + "This Supplier is not available, please check before update.!");
        }
        categoryRepo.save(mapper.map(categoryDTO, Category.class));
    }

    @Override
    public ResponseEntity<Category> remove(Long id) {
        if (itemRepo.existsByCategory_Id(id))
            return ResponseEntity
                    .ok()
                    .header("error", "Cant' Delete Because Your May Data Lost")
                    .build();
        if (!categoryRepo.existsById(id)) {
            return ResponseEntity
                    .notFound()
                    .header("error", "Can't Find This Id")
                    .build();
        } else {
            categoryRepo.delete(categoryRepo.getReferenceById(Long.valueOf(id)));
        }
        return ResponseEntity
                .noContent()
                .build();
    }

    @Override
    public CategoryDTO findUnit(Long id) {
        return mapper.map(categoryRepo.findById(Long.valueOf(id)), CategoryDTO.class);

    }

    @Override
    public List<CategoryDTO> findAllUnit() {
        return mapper.map(categoryRepo.findAll(), new TypeToken<List<CategoryDTO>>() {
        }.getType());
    }

    @Override
    public List<CategoryDTO> findAllUnitLikeIdAndName(String text) {
        return mapper.map(categoryRepo.findAllUnitLikeIdAndName(text + "%", text + "%"), new TypeToken<List<CategoryDTO>>() {
        }.getType());
    }

    @Override
    public Long countByAll() {
        return categoryRepo.count();
    }


}
