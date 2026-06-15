package TRA_Springboot_Immigration_System.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Applicant")
public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;

   @OneToMany
    private List<VisaApplications> visApplications;

    @OneToMany
    private List<Interview> interviews;
}
