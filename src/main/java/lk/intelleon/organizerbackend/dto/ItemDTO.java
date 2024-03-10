package lk.intelleon.organizerbackend.dto;

import lk.intelleon.organizerbackend.entity.enumretion.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/5/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemDTO {

    private long id;
    private String code;
    private String name;
    private CategoryDTO category;
    private UnitDTO unit;
    private Status status;

}
