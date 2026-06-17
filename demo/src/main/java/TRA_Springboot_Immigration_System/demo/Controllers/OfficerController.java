package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.DTO.OfficerDTO;
import TRA_Springboot_Immigration_System.demo.Entities.BorderControlOffice;
import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import TRA_Springboot_Immigration_System.demo.Repositories.CenterRepository;
import TRA_Springboot_Immigration_System.demo.Repositories.OfficerRepository;
import TRA_Springboot_Immigration_System.demo.Services.OfficerService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("officer")
public class OfficerController {

    OfficerService officerService;
    @Autowired
    public OfficerController(OfficerService officerService) {
        this.officerService=officerService;
    }

    @PostMapping("/hireStandardOfficer")
    public ResponseEntity<OfficerDTO> hireStandardOfficer(@RequestBody ImmigrationOfficer officer) {
        return ResponseEntity.ok(OfficerDTO.convertToDTO(officerService.hireStandardOfficer(officer)));
    }

    @PostMapping("/hireBorderOfficer")
    public ResponseEntity<OfficerDTO> hireBorderOfficer(@RequestBody BorderControlOffice borderRequest){
        return ResponseEntity.ok(OfficerDTO.convertToDTO(officerService.hireBorderOfficer(borderRequest)));
    }

    @GetMapping("/getOfficerDetailsById/{id}")
    public ResponseEntity<OfficerDTO> getOfficerDetailsById(@PathVariable Long id){
        return ResponseEntity.ok(OfficerDTO.convertToDTO(officerService.getOfficerDetailsById(id)));
    }

    @PostMapping("/promoteOfficer/{officerId}")
    public ResponseEntity<OfficerDTO> promoteOfficer(@PathVariable Long officerId, @RequestParam String newRank, @RequestParam int newClearanceLevel){
        return ResponseEntity.ok(OfficerDTO.convertToDTO(officerService.promoteOfficer(officerId,newRank,newClearanceLevel)));
    }

    @PutMapping("/transferOfficer/{officerId}")
    public ResponseEntity<OfficerDTO> transferOfficer(@PathVariable Long officerId,@RequestParam Long newCenterId){
        return ResponseEntity.ok(OfficerDTO.convertToDTO(officerService.transferOfficer(officerId,newCenterId)));
    }

    /*public ResponseEntity<List<ImmigrationOfficer>> findByRank(String rank){
        return ResponseEntity.ok(officerService.findByRank(rank));
    }

    public ResponseEntity<List<ImmigrationOfficer>> findByRank(String rank, int minimumClearanceLevel){
        return ResponseEntity.ok(officerService.findByRank(rank,minimumClearanceLevel));
    }*/
}
