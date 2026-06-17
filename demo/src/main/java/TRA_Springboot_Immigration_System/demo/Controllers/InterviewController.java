package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.DTO.InterviewDTO;
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
    public ResponseEntity<InterviewDTO> scheduleInterview(@PathVariable Long applicantId, @PathVariable Long officerId, @RequestParam String date){
        return ResponseEntity.ok(InterviewDTO.convertToDTO(interviewService.scheduleInterview(applicantId,officerId,date)));
    }

    @PutMapping("/cancelInterview/{id}")
    public ResponseEntity<InterviewDTO> cancelInterview(@PathVariable Long id){
        //Interview cancelledInterview=interviewService.cancelInterview(id);
        return ResponseEntity.ok(InterviewDTO.convertToDTO(interviewService.cancelInterview(id)));
    }

    @PutMapping("/completeInterview/{id}")
    public ResponseEntity<InterviewDTO> completeInterview(@PathVariable Long interviewId){
        return ResponseEntity.ok(InterviewDTO.convertToDTO(interviewService.completeInterview(interviewId)));
    }

    @GetMapping("/getAllInterviews/{officerId}")
    public ResponseEntity<List<Interview>> getAllInterviews(@RequestParam Long officerId,  @RequestParam String date){
        //List<Interview> scheduleInterviews=interviewService.getOfficerSchedule(officerId,date);
        return ResponseEntity.ok(interviewService.getOfficerSchedule(officerId,date));
    }
}
