package lk.intelleon.organizerbackend.dto;

import lk.intelleon.organizerbackend.entity.enumretion.ApprovalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author Sasindu Malshan
 * @project Interleaon
 * @date 3/5/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InventoryDTO {
    private long id;
    private ItemDTO item;
    private LocalDate received_date;
    private LocalDate expire_date;
    private int received_qty;
    private ApprovalStatus approval_status;
    private String status;
}
