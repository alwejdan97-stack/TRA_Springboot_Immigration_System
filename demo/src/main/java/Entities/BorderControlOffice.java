package Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorderControlOffice extends ImmegrationOfficer{
    private String assignedCheckPoint;
    private Boolean k9UnitAssigned;
}
