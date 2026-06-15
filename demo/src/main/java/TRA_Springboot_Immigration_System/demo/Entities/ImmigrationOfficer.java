package TRA_Springboot_Immigration_System.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ImmigrationOfficer")
public class ImmigrationOfficer extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String badgeNumber;
    @Column(name = "officerRank")
    private String rank;
    private int clearanceLevel;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private ImmigrationCenter immigrationCenter;

    @OneToMany
    private List<Interview> interview;
}
