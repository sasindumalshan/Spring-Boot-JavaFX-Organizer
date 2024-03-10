package lk.intelleon.organizerbackend.controller;

import lk.intelleon.organizerbackend.advisor.AppWideExceptionHandler;
import lk.intelleon.organizerbackend.dto.CategoryDTO;
import lk.intelleon.organizerbackend.entity.Category;
import lk.intelleon.organizerbackend.service.CategoryService;
import lk.intelleon.organizerbackend.utility.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/4/2024
 */
@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getSupplier(Long id) {
        return new ResponseUtil("200", "ok", service.findUnit(id));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil save(@RequestBody CategoryDTO categoryDTO) {
        try {
            service.save(categoryDTO);
        } catch (Exception e) {
            return new AppWideExceptionHandler().handleAllRuntimeExceptions(new RuntimeException("Something wrongs add date"));
        }
        return new ResponseUtil("200", "add Successful", categoryDTO.getId());
    }

    @GetMapping(path = "findAll")
    public ResponseUtil findAll() {
        return new ResponseUtil("200", "ok", service.findAllUnit());
    }

    @GetMapping(path = "search")
    public ResponseUtil search(String id) {
        return new ResponseUtil("200", "ok", service.findAllUnitLikeIdAndName(id));
    }

    @PostMapping(path = "update")
    public ResponseUtil update(@RequestBody CategoryDTO categoryDTO) {
        try {
            service.update(categoryDTO);
        } catch (Exception e) {
            return new AppWideExceptionHandler().handleAllRuntimeExceptions(new RuntimeException("Something wrongs update data"));
        }
        return new ResponseUtil("200", "update Successful", categoryDTO.getId());
    }

    @DeleteMapping
    public ResponseEntity<Category> remove(Long id) {
        try {
            return service.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().header("error",new RuntimeException("Something wrongs Remove data").getMessage()).build();
        }
    }

    @GetMapping(path = "countByAll")
    public ResponseUtil countByAll() {
        return new ResponseUtil("200", "remove Successful", service.countByAll());
    }
}
