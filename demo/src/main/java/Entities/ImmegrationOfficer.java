package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ImmegrationOfficer extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String badgeNumber;
    private String rank;
    private int clearanceLevel;
    private Boolean active;

    @ManyToOne
    private List<Center> centerList;

    @OneToMany
    private List<Interview> interviewList;
}
