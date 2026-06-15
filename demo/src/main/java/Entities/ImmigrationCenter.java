package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImmigrationCenter {
    private long id;
    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;

    @OneToMany
    private List<ImmigrationOfficer> officer;
}
