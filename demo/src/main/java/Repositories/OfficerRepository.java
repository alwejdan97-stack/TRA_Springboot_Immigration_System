package Repositories;

import Entities.ImmigrationOfficer;
import Entities.VisaApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficerRepository extends JpaRepository<ImmigrationOfficer,Long> {
    List<ImmigrationOfficer> findByOfficeId(Long officeId);
}
