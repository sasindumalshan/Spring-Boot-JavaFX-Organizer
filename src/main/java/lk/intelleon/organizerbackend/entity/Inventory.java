package lk.intelleon.organizerbackend.entity;


import jakarta.persistence.*;
import lk.intelleon.organizerbackend.entity.enumretion.ApprovalStatus;
import lk.intelleon.organizerbackend.entity.enumretion.Status;
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

@Entity(name = "tbl_master_inventory")
public class Inventory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "received_date", columnDefinition = "DATE")
    private LocalDate received_date;

    @Column(name = "expire_date", columnDefinition = "DATE")
    private LocalDate expire_date;

    @Column(name = "received_qty", columnDefinition = "INT")
    private int received_qty;

    @Column(name = "approval_status")
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approval_status;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "item", referencedColumnName = "id")
    private Item item;
}

