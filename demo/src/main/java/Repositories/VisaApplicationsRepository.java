package Repositories;

import Entities.VisaApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisaApplicationsRepository extends JpaRepository<VisaApplications,Long> {
    List<VisaApplications> findByVisaApplicantId(Long applicantId);
    List<VisaApplications> findByVisaApplicantStatus(String status);
}
