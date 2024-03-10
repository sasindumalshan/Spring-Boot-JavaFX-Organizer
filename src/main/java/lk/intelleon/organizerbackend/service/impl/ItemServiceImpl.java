package lk.intelleon.organizerbackend.service.impl;

import lk.intelleon.organizerbackend.dto.CategoryDTO;
import lk.intelleon.organizerbackend.dto.ItemDTO;
import lk.intelleon.organizerbackend.entity.Item;
import lk.intelleon.organizerbackend.repository.CategoryRepo;
import lk.intelleon.organizerbackend.repository.ItemRepo;
import lk.intelleon.organizerbackend.repository.UnitRepo;
import lk.intelleon.organizerbackend.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/5/2024
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    UnitRepo unitRepo;

    @Autowired
    ItemRepo itemRepo;

    @Override
    public void save(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getId())) {
            throw new RuntimeException(itemDTO.getId() + " This Item is Already available");
        }
        itemRepo.save(mapper.map(itemDTO, Item.class));
    }

    @Override
    public void update(ItemDTO itemDTO) {
        if (!itemRepo.existsById(itemDTO.getId())) {
            throw new RuntimeException(itemDTO.getId() + " This Item is not available");
        }
        itemRepo.save(mapper.map(itemDTO, Item.class));
    }

    @Override
    public ResponseEntity<Item> remove(Long id) {

        if (itemRepo.existsByUnit_Id(id))
            return ResponseEntity
                    .ok()
                    .header("error", "Cant' Delete Because Your May Data Lost")
                    .build();
        if (!itemRepo.existsById(id)) {
            return ResponseEntity
                    .notFound()
                    .header("error", "Can't Find This Id")
                    .build();
        } else {
            itemRepo.delete(itemRepo.getReferenceById(Long.valueOf(id)));
        }
        return ResponseEntity
                .noContent()
                .build();
    }

    @Override
    public ItemDTO findItem(Long id) {
        return mapper.map(itemRepo.findById(Long.valueOf(id)), ItemDTO.class);
    }

    @Override
    public List<ItemDTO> findAllItem() {
        return mapper.map(itemRepo.findAll(), new TypeToken<List<ItemDTO>>() {
        }.getType());
    }

    @Override
    public List<ItemDTO> findAllItemLikeIdAndName(String text) {
        return mapper.map(itemRepo.findAllUnitLikeIdAndName(text + "%", text + "%"), new TypeToken<List<CategoryDTO>>() {
        }.getType());
    }

    @Override
    public Long countByAll() {
        return itemRepo.count();
    }

    @Override
    public boolean isExitsByCategory(Long id) {
        return itemRepo.existsByCategory_Id(id);
    }


}
