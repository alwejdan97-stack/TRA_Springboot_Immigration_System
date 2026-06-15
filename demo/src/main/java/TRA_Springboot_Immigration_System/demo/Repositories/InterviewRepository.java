package TRA_Springboot_Immigration_System.demo.Repositories;

import TRA_Springboot_Immigration_System.demo.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Long> {
    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String date);
}
