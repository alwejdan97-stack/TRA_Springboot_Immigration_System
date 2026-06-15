package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BorderControlOffice")
public class BorderControlOffice extends ImmigrationOfficer {
    private String assignedCheckPoint;
    private Boolean k9UnitAssigned;
}
