package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Entities.AsylumSeeker;
import TRA_Springboot_Immigration_System.demo.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("applicant")
public class ApplicantController {
    ApplicantService applicantService;
    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public ResponseEntity<Applicant> registerApplicant(@RequestBody Applicant applicant) {
        return ResponseEntity.ok(applicantService.saveApplicant(applicant));
    }

    @PostMapping("/asylum")
    public ResponseEntity<AsylumSeeker> registerAsylumSeeker(@RequestBody AsylumSeeker seeker) {
        return ResponseEntity.ok(applicantService.registerAsylumSeeker(seeker));
    }

    @GetMapping
    public ResponseEntity<List<Applicant>> getAllApplicants() {
        return ResponseEntity.ok(applicantService.getAllApplicants());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Applicant>> findApplicantsByNationality(@RequestParam String nationality) {
        return ResponseEntity.ok(applicantService.findApplicantsByNationality(nationality));
    }


    public ResponseEntity<Applicant> flagCriminalRecord(@PathVariable Long id) {
        return ResponseEntity.ok(applicantService.flagCriminalRecord(id));
    }
}
