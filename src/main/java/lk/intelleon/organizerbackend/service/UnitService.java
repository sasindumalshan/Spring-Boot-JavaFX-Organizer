package lk.intelleon.organizerbackend.service;

import lk.intelleon.organizerbackend.dto.UnitDTO;
import lk.intelleon.organizerbackend.entity.Unit;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/4/2024
 */

public interface UnitService {
    void save(UnitDTO unitDTO);

    void update(UnitDTO unitDTO);

    ResponseEntity<Unit> remove(Long id);

    UnitDTO findUnit(Long id);

    List<UnitDTO> findAllUnit();

    List<UnitDTO> findAllUnitLikeIdAndName(String id);

    Long countByAll();
}
