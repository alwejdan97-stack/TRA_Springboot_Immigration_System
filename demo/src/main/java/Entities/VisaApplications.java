package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VisaApplications")
public class VisaApplications {
    private long id;
    private String visaType;
    private String status;
    private String officerNotes;

    @ManyToOne
    private List<ImmigrationOfficer> handlingOfficer;

    @ManyToOne
    private List<Applicant> applicant;
}
