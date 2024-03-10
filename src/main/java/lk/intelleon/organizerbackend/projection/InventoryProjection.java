package lk.intelleon.organizerbackend.projection;

import java.time.LocalDate;

/**
 * @author Sasindu Malshan
 * @project organizer-backend
 * @date 3/10/2024
 */

public interface InventoryProjection {
    Long getId();
    String getQTY();
    String getItemName();
    LocalDate getExpireDate();
    String getCategoryName();
}
