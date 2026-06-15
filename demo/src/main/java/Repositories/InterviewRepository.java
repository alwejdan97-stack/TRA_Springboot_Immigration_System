package Repositories;

import Entities.Applicant;
import Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Long> {
    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String date);
}
