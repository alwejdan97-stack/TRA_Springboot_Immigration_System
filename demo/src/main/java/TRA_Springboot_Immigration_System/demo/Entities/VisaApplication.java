package TRA_Springboot_Immigration_System.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VisaApplications")
public class VisaApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String visaType;
    private String status;
    private String officerNotes;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private ImmigrationOfficer handlingOfficer;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}
