package TRA_Springboot_Immigration_System.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String interviewDate;
    private String status;
    private String purpose;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private ImmigrationOfficer officer;
}
