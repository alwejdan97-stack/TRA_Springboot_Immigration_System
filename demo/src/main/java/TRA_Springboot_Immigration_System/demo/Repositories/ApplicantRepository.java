package TRA_Springboot_Immigration_System.demo.Repositories;

import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    List<Applicant> findByNationality(String nationality);

    @Query("SELECT A FROM Applicant A WHERE A.id=applicantId")
    Applicant findApplicantById(@Param("applicantId") Long applicantId);

    boolean existFirstNameLastName(String firstName, String lastName);
}
