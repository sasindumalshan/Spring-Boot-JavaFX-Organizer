package lk.intelleon.organizerbackend.service.impl;

import lk.intelleon.organizerbackend.dto.CategoryDTO;
import lk.intelleon.organizerbackend.dto.SupplierDTO;
import lk.intelleon.organizerbackend.entity.Supplier;
import lk.intelleon.organizerbackend.repository.SupplierRepo;
import lk.intelleon.organizerbackend.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/4/2024
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    SupplierRepo supplierRepo;

    @Override
    public void save(SupplierDTO supplierDTO) {
        if (supplierRepo.existsById(Long.valueOf(supplierDTO.getId()))) {
            throw new RuntimeException(supplierDTO.getId() + " This Supplier is Already available");
        }
        supplierRepo.save(mapper.map(supplierDTO, Supplier.class));
    }

    @Override
    public void update(SupplierDTO supplierDTO) {
        if (!supplierRepo.existsById(Long.valueOf(supplierDTO.getId()))) {
            throw new RuntimeException(supplierDTO.getId() + " This Supplier is not available, please check before update.!");
        }
        supplierRepo.save(mapper.map(supplierDTO, Supplier.class));
    }

    @Override
    public void remove(Long id) {
        if (!supplierRepo.existsById(id)) {
            throw new RuntimeException(id + " This Supplier is not available, please check before delete.!");
        }
        supplierRepo.deleteById(id);
    }

    @Override
    public SupplierDTO findUnit(Long id) {
        return mapper.map(supplierRepo.findById(id), SupplierDTO.class);
    }

    @Override
    public List<SupplierDTO> findAllUnit() {
        return mapper.map(supplierRepo.findAll(), new TypeToken<List<SupplierDTO>>() {
        }.getType());
    }

    @Override
    public List<SupplierDTO> findAllSupplierLikeIdAndName(String text) {
        return mapper.map(supplierRepo.findAllUnitLikeIdAndName(text + "%", text + "%"), new TypeToken<List<CategoryDTO>>() {
        }.getType());
    }

    @Override
    public Long countByAll() {
        return supplierRepo.count();
    }
}
