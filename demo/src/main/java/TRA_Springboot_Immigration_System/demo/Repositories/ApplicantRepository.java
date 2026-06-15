package TRA_Springboot_Immigration_System.demo.Repositories;

import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    List<Applicant> findByNationality(String nationality);
}
