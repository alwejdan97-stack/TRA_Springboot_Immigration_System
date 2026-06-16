package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.Entities.Interview;
import TRA_Springboot_Immigration_System.demo.Services.InterviewService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    InterviewService interviewService;
    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PutMapping("/scheduleInterview/{applicantId}/{officerId}")
    public ResponseEntity<Interview> scheduleInterview(@PathVariable Long applicantId, @PathVariable Long officerId, @RequestParam String date){
        return ResponseEntity.ok(interviewService.scheduleInterview(applicantId,officerId,date));
    }

    @PutMapping("/cancelInterview/{id}")
    public ResponseEntity<Interview> cancelInterview(@PathVariable Long id){
        //Interview cancelledInterview=interviewService.cancelInterview(id);
        return ResponseEntity.ok(interviewService.cancelInterview(id));
    }

    @PutMapping("/completeInterview/{id}")
    public ResponseEntity<Interview> completeInterview(@PathVariable Long interviewId){
        return ResponseEntity.ok(interviewService.completeInterview(interviewId));
    }

    @GetMapping("/getAllInterviews/{officerId}")
    public ResponseEntity<List<Interview>> getAllInterviews(@RequestParam Long officerId,  @RequestParam String date){
        //List<Interview> scheduleInterviews=interviewService.getOfficerSchedule(officerId,date);
        return ResponseEntity.ok(interviewService.getOfficerSchedule(officerId,date));
    }
}
