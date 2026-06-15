package TRA_Springboot_Immigration_System.demo.Repositories;

import TRA_Springboot_Immigration_System.demo.Entities.VisaApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisaApplicationsRepository extends JpaRepository<VisaApplications,Long> {
    List<VisaApplications> findByVisaApplicantId(Long applicantId);
    List<VisaApplications> findByVisaApplicantStatus(String status);
}
