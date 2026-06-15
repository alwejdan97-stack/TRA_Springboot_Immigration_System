package Entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Officer extends Person{
    private long id;
    private String badgeNumber;
    private String rank;
    private int clearanceLevel;
    private Boolean active;
}
