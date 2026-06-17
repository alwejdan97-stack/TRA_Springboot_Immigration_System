package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.DTO.ApplicantDTO;
import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Entities.AsylumSeeker;
import TRA_Springboot_Immigration_System.demo.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicant")
public class ApplicantController {
    ApplicantService applicantService;
    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping("/registerApplicant")
    public ResponseEntity<ApplicantDTO> registerApplicant(@RequestBody Applicant applicant) {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.saveApplicant(applicant)));
    }

    @PostMapping("/asylum")
    public ResponseEntity<ApplicantDTO> registerAsylumSeeker(@RequestBody AsylumSeeker seeker) {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.registerAsylumSeeker(seeker)));
    }

    @GetMapping("/getAllApplicants")
    public ResponseEntity<List<ApplicantDTO>> getAllApplicants() {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.getAllApplicants()));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ApplicantDTO>> findApplicantsByNationality(@RequestParam String nationality) {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.findApplicantsByNationality(nationality)));
    }

    @PutMapping("/flag/{id}")
    public ResponseEntity<ApplicantDTO> flagCriminalRecord(@PathVariable Long id) {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.flagCriminalRecord(id)));
    }
}
