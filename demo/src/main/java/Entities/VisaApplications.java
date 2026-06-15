package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisaApplications {
    private long id;
    private String visaType;
    private String status;
    private String officerNotes;

    @ManyToOne
    private List<HandlingOfficer> handlingOfficerList;

    @ManyToOne
    private List<Applicant> applicantList;
}
