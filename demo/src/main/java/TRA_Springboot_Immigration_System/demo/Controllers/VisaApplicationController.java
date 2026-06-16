package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.Entities.VisaApplication;
import TRA_Springboot_Immigration_System.demo.Services.VisaApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("visaApplication")
public class VisaApplicationController {
    VisaApplicationsService visaApplicationsService;

    @Autowired
    public VisaApplicationController(VisaApplicationsService visaApplicationsService) {
        this.visaApplicationsService = visaApplicationsService;
    }

    @PostMapping("/submissionApplication")
    public ResponseEntity<VisaApplication> submissionApplication(@PathVariable Long applicantId, @RequestParam String visaType){
        VisaApplication newVisa=visaApplicationsService.submissionApplication(applicantId,visaType);
        return new ResponseEntity<>(newVisa, HttpStatus.CREATED);
    }

    @PutMapping("/assignedOfficer/{visaId}/{officerId}")
    public ResponseEntity<VisaApplication> assignedOfficer(@PathVariable Long visaId, @PathVariable Long officerId){
        return ResponseEntity.ok(visaApplicationsService.assignedOfficer(visaId, officerId));
    }

    @PutMapping("/processVisa/{visaId}")
    public ResponseEntity<VisaApplication> processVisa(@PathVariable Long visaId, @RequestParam String newStatus, @RequestParam String notes){
        return ResponseEntity.ok(visaApplicationsService.processVisa(visaId, newStatus, notes));
    }

    @GetMapping("/getVisasByStatus/{status}")
    public ResponseEntity<List<VisaApplication>> getVisasByStatus(@PathVariable String status) {
        return ResponseEntity.ok(visaApplicationsService.getVisasByStatus(status));
    }

    @GetMapping("/getVisasByApplicant/{applicantId}")
    public ResponseEntity<List<VisaApplication>> getVisasByApplicant(@PathVariable Long applicantId){
        return ResponseEntity.ok(visaApplicationsService.getVisasByApplicantId(applicantId));
    }
}
