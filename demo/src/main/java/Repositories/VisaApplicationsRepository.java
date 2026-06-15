package Repositories;

import Entities.VisaApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaApplicationsRepository extends JpaRepository<VisaApplications,Long> {
}
