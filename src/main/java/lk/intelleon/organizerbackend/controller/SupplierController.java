package lk.intelleon.organizerbackend.controller;

import lk.intelleon.organizerbackend.advisor.AppWideExceptionHandler;
import lk.intelleon.organizerbackend.dto.SupplierDTO;
import lk.intelleon.organizerbackend.service.SupplierService;
import lk.intelleon.organizerbackend.utility.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/4/2024
 */
@RestController
@RequestMapping("/supplier")
@CrossOrigin
public class SupplierController {
    @Autowired
    SupplierService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getSupplier(Long id) {
        return new ResponseUtil("200", "ok", service.findUnit(id));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil save(@RequestBody SupplierDTO supplierDTO) {
        try {
            service.save(supplierDTO);
        } catch (Exception e) {
            return new AppWideExceptionHandler().handleAllRuntimeExceptions(new RuntimeException("Something wrongs add date"));
        }
        return new ResponseUtil("200", "add Successful", supplierDTO.getId());
    }

    @GetMapping(path = "findAll")
    public ResponseUtil findAll() {
        return new ResponseUtil("200", "ok", service.findAllUnit());
    }

    @PostMapping(path = "update")
    public ResponseUtil update(@RequestBody SupplierDTO supplierDTO) {
        try {
            service.update(supplierDTO);
        } catch (Exception e) {
            return new AppWideExceptionHandler().handleAllRuntimeExceptions(new RuntimeException("Something wrongs update data"));
        }
        return new ResponseUtil("200", "update Successful", supplierDTO.getId());
    }

    @DeleteMapping
    public ResponseUtil remove(Long id) {
        try {
            service.remove(id);
        } catch (Exception e) {
            return new AppWideExceptionHandler().handleAllRuntimeExceptions(new RuntimeException("Something wrongs Remove data"));
        }
        return new ResponseUtil("200", "remove Successful", id);
    }

    @GetMapping(path = "search")
    public ResponseUtil search(String id) {
        return new ResponseUtil("200", "ok", service.findAllSupplierLikeIdAndName(id));
    }

    @GetMapping(path = "countByAll")
    public ResponseUtil countByAll() {
        return new ResponseUtil("200", "remove Successful", service.countByAll());
    }
}
