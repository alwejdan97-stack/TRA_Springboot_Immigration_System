package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interview {
    private long id;
    private String interviewDate;
    private String status;
    private String purpose;

    @ManyToOne
    private List<Applicant> applicant;

    @ManyToOne
    private List<ImmigrationOfficer> officer;
}
