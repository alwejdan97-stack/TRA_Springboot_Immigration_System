package Repositories;

import Entities.Applicant;
import Entities.ImmigrationCenter;
import Entities.VisaApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<ImmigrationCenter,Long> {
    List<ImmigrationCenter> findByCenterId(Long centerId);
    List<ImmigrationCenter> findByCenterName(String centerName);
}
