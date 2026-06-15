package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;

    @OneToMany
    private List<VisApplications> visApplicationsList;

    @OneToMany
    private List<Interviews> interviewsListnterviews;
}
