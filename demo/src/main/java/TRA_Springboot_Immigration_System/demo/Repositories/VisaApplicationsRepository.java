package TRA_Springboot_Immigration_System.demo.Repositories;

import TRA_Springboot_Immigration_System.demo.Entities.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisaApplicationsRepository extends JpaRepository<VisaApplication,Long> {
    List<VisaApplication> getVisaByApplicantId(Long applicantId);
    List<VisaApplication> findByVisaApplicantStatus(String status);
}
