package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationCenter;
import TRA_Springboot_Immigration_System.demo.Exceptions.CenterException;
import TRA_Springboot_Immigration_System.demo.Exceptions.ErrorMessages;
import TRA_Springboot_Immigration_System.demo.Services.CenterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class CenterController {
    CenterServer centerServer;
    @Autowired
    public CenterController(CenterServer centerServer) {
        this.centerServer = centerServer;
    }

    @PostMapping("/saveCenter")
    public ResponseEntity<ImmigrationCenter> saveCenter(@RequestBody ImmigrationCenter center){
        return ResponseEntity.ok(centerServer.saveCenter(center));
    }

    @GetMapping("/findByCenterId/{centerId}")
    public ResponseEntity<List<ImmigrationCenter>> findByCenterId(@PathVariable Long centerId){
        return ResponseEntity.ok(centerServer.findByCenterId(centerId));
    }

    @GetMapping("/findByCenterName")
    public ResponseEntity<List<ImmigrationCenter>> findByCenterName(@RequestParam String centerName){
       return ResponseEntity.ok(centerServer.findByCenterName(centerName));
    }
}
