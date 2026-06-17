package TRA_Springboot_Immigration_System.demo.Repositories;

import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<ImmigrationCenter,Long> {
    ImmigrationCenter findByCenterId(Long centerId);
    List<ImmigrationCenter> findByCenterName(String centerName);
}
