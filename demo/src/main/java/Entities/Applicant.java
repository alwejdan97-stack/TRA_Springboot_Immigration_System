package Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;

   @OneToMany
    private List<VisApplications> visApplicationsList;

    @OneToMany
    private List<Interviews> interviewsListnterviews;
}
