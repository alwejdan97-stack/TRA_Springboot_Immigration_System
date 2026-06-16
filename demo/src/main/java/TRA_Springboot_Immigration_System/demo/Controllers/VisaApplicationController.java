package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.Entities.VisaApplication;
import TRA_Springboot_Immigration_System.demo.Services.VisaApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("visaApplication")
public class VisaApplicationController {
    VisaApplicationsService visaApplicationsService;

    @Autowired
    public VisaApplicationController(VisaApplicationsService visaApplicationsService) {
        this.visaApplicationsService = visaApplicationsService;
    }

    public ResponseEntity<VisaApplication> submissionApplication(@PathVariable Long applicantId, @RequestParam String visaType){
        VisaApplication newVisa=visaApplicationsService.submissionApplication(applicantId,visaType);
        return new ResponseEntity<>(newVisa, HttpStatus.CREATED);
    }

    public ResponseEntity<VisaApplication> assignedOfficer(Long visaId, Long officerId){
        return ResponseEntity.ok(visaApplicationsService.assignedOfficer(visaId, officerId));
    }

    public ResponseEntity<VisaApplication> processVisa(Long visaId, String newStatus, String notes){
        return ResponseEntity.ok(visaApplicationsService.processVisa(visaId, newStatus, notes));
    }

    public ResponseEntity<List<VisaApplication>> getVisasByStatus(@PathVariable String status) {
        return ResponseEntity.ok(visaApplicationsService.getVisasByStatus(status));
    }

    public ResponseEntity<List<VisaApplication>> getVisasByApplicant(@PathVariable Long applicantId){
        return ResponseEntity.ok(visaApplicationsService.getVisasByApplicantId(applicantId));
    }
}
