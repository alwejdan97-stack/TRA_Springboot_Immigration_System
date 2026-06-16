package TRA_Springboot_Immigration_System.demo.Controllers;

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

    @PostMapping("hireStandardOfficer")
    public ResponseEntity<ImmigrationOfficer> hireStandardOfficer(@RequestBody ImmigrationOfficer officer) {
        return ResponseEntity.ok(officerService.hireStandardOfficer(officer));
    }

    public ResponseEntity<ImmigrationOfficer> hireBorderOfficer(@RequestBody BorderControlOffice borderRequest){
        return ResponseEntity.ok(officerService.hireBorderOfficer(borderRequest));
    }

    public ResponseEntity<ImmigrationOfficer> getOfficerDetailsById(@PathVariable Long id){
        return ResponseEntity.ok(officerService.getOfficerDetailsById(id));
    }

    public ResponseEntity<ImmigrationOfficer> promoteOfficer(@PathVariable Long officerId, @RequestParam String newRank, @RequestParam int newClearanceLevel){
        return ResponseEntity.ok(officerService.promoteOfficer(officerId,newRank,newClearanceLevel));
    }

    public ResponseEntity<ImmigrationOfficer> transferOfficer(Long officerId,Long newCenterId){
        return ResponseEntity.ok(officerService.transferOfficer(officerId,newCenterId));
    }

    /*public ResponseEntity<List<ImmigrationOfficer>> findByRank(String rank){
        return ResponseEntity.ok(officerService.findByRank(rank));
    }

    public ResponseEntity<List<ImmigrationOfficer>> findByRank(String rank, int minimumClearanceLevel){
        return ResponseEntity.ok(officerService.findByRank(rank,minimumClearanceLevel));
    }*/
}
