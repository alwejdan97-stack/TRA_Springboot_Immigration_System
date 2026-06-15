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
@Table(name = "ImmigrationCenter")
public class ImmigrationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;

    @OneToMany
    private List<ImmigrationOfficer> officer;
}
