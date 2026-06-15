package Entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class AsylumSeeker extends Applicant {
    private String countryOfOrigin;
    private String sponsorOrganization;
}
