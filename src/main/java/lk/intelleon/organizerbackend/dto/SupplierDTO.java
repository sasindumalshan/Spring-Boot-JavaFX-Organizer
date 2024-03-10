package lk.intelleon.organizerbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/3/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class SupplierDTO {

    String id;
    String code;
    String name;
    String address;
    private String status;


}
