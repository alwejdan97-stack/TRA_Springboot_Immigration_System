package TRA_Springboot_Immigration_System.demo.Repositories;

import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficerRepository extends JpaRepository<ImmigrationOfficer,Long> {
    List<ImmigrationOfficer> findByOfficeId(Long officeId);
    List<ImmigrationOfficer> findByBadgeNumber(String badgeNumber);
}
