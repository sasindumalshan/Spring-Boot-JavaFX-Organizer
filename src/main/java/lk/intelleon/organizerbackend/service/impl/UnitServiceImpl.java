package lk.intelleon.organizerbackend.service.impl;

import lk.intelleon.organizerbackend.dto.UnitDTO;
import lk.intelleon.organizerbackend.entity.Unit;
import lk.intelleon.organizerbackend.repository.ItemRepo;
import lk.intelleon.organizerbackend.repository.UnitRepo;
import lk.intelleon.organizerbackend.service.UnitService;
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
public class UnitServiceImpl implements UnitService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    UnitRepo unitRepo;

    @Autowired
    ItemRepo itemRepo;

    @Override
    public void save(UnitDTO unitDTO) {
        if (unitRepo.existsById(Long.valueOf(unitDTO.getId()))) {
            throw new RuntimeException(unitDTO.getId() + " This Supplier is Already available");
        }
        unitRepo.save(mapper.map(unitDTO, Unit.class));
    }

    @Override
    public void update(UnitDTO unitDTO) {
        if (!unitRepo.existsById(Long.valueOf(unitDTO.getId()))) {
            throw new RuntimeException(unitDTO.getId() + "This Supplier is not available, please check before update.!");
        }
        unitRepo.save(mapper.map(unitDTO, Unit.class));
    }

    @Override
    public ResponseEntity<Unit> remove(Long id) {
        if (itemRepo.existsByCategory_Id(id))
            return ResponseEntity
                    .ok()
                    .header("error", "Cant' Delete Because Your May Data Lost")
                    .build();
        if (!unitRepo.existsById(id)) {
            return ResponseEntity
                    .notFound()
                    .header("error", "Can't Find This Id")
                    .build();
        } else {
            unitRepo.delete(unitRepo.getReferenceById(Long.valueOf(id)));
        }
        return ResponseEntity
                .noContent()
                .build();
    }

    @Override
    public UnitDTO findUnit(Long id) {
        return mapper.map(unitRepo.findById(Long.valueOf(id)), UnitDTO.class);
    }

    @Override
    public List<UnitDTO> findAllUnit() {
        return mapper.map(unitRepo.findAll(), new TypeToken<List<UnitDTO>>() {
        }.getType());
    }

    @Override
    public List<UnitDTO> findAllUnitLikeIdAndName(String text) {
        return mapper.map(unitRepo.findAllUnitLikeIdAndName(text + "%", text + "%"), new TypeToken<List<UnitDTO>>() {
        }.getType());
    }

    @Override
    public Long countByAll() {
        return unitRepo.count();
    }
}
