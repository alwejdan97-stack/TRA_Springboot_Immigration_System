package Entities;
import Entities.Person;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Applicant extends Person{
    private Integer id;
    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;

}
