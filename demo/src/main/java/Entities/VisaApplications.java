package Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisaApplications {
    private long id;
    private String visaType;
    private String status;
    private String officerNotes;
}
