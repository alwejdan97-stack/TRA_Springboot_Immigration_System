package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.DTO.VisaApplicationDTO;
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
    public ResponseEntity<VisaApplicationDTO> submissionApplication(@PathVariable Long applicantId, @RequestParam String visaType){
        VisaApplication newVisa=visaApplicationsService.submissionApplication(applicantId,visaType);
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(newVisa));
    }

    @PutMapping("/assignedOfficer/{visaId}/{officerId}")
    public ResponseEntity<VisaApplicationDTO> assignedOfficer(@PathVariable Long visaId, @PathVariable Long officerId){
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationsService.assignedOfficer(visaId, officerId)));
    }

    @PutMapping("/processVisa/{visaId}")
    public ResponseEntity<VisaApplicationDTO> processVisa(@PathVariable Long visaId, @RequestParam String newStatus, @RequestParam String notes){
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationsService.processVisa(visaId, newStatus, notes)));
    }

    @GetMapping("/getVisasByStatus/{status}")
    public ResponseEntity<List<VisaApplicationDTO>> getVisasByStatus(@PathVariable String status) {
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationsService.getVisasByStatus(status)));
    }

    @GetMapping("/getVisasByApplicant/{applicantId}")
    public ResponseEntity<List<VisaApplicationDTO>> getVisasByApplicant(@PathVariable Long applicantId){
        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationsService.getVisasByApplicantId(applicantId)));
    }
}