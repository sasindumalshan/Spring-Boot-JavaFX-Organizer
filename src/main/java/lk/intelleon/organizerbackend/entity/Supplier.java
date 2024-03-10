package lk.intelleon.organizerbackend.entity;


import jakarta.persistence.*;
import lk.intelleon.organizerbackend.entity.enumretion.Status;
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

@Entity(name = "tbl_master_suppliers")
public class Supplier {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "code", columnDefinition = "VARCHAR(64)")
    String code;
    @Column(name = "name", columnDefinition = "VARCHAR(64)")
    String name;
    @Column(name = "address")
    String address;
    @Enumerated(EnumType.STRING)
    private Status status;

}
