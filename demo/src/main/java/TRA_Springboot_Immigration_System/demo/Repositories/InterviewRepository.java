package TRA_Springboot_Immigration_System.demo.Repositories;

import TRA_Springboot_Immigration_System.demo.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Long> {
    @Query("SELECT I FROM Interview I WHERE I.officer.id=:officer_id AND I.interviewDate=:interviewDate")
    List<Interview> findByOfficerIdAndInterviewDate(@Param("officer_id") Long officerId, @Param("interviewDate") String date);
}
