package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AsylumSeeker")
public class AsylumSeeker extends Applicant {
    private String countryOfOrigin;
    private String sponsorOrganization;
}
