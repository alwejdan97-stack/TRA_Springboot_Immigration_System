package TRA_Springboot_Immigration_System.demo.Controllers;

import TRA_Springboot_Immigration_System.demo.Entities.*;
import TRA_Springboot_Immigration_System.demo.Repositories.ApplicantRepository;
import TRA_Springboot_Immigration_System.demo.Repositories.CenterRepository;
import TRA_Springboot_Immigration_System.demo.Repositories.OfficerRepository;
import TRA_Springboot_Immigration_System.demo.Services.ApplicantService;
import TRA_Springboot_Immigration_System.demo.Services.CenterServer;
import TRA_Springboot_Immigration_System.demo.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/databaseSeedController")
public class DatabaseSeedController {
    CenterRepository centerRepository;
    OfficerRepository officerRepository;
    ApplicantRepository applicantRepository;
    @Autowired
    public DatabaseSeedController(CenterRepository centerRepository, OfficerRepository officerRepository, ApplicantRepository applicantRepository) {
        this.centerRepository = centerRepository;
        this.officerRepository = officerRepository;
        this.applicantRepository = applicantRepository;
    }

    @PostMapping("/databaseSeed")
    public String databaseSeed(){
        ImmigrationCenter center1=new ImmigrationCenter();
        center1.setName("Muscat Center");
        center1.setLocationCountry("Oman");
        center1.setType("Main");
        center1.setDailyCapacity(100);
        centerRepository.save(center1);
        ImmigrationCenter center2=new ImmigrationCenter();
        center2.setName("Salalah Center");
        center2.setLocationCountry("Oman");
        center2.setType("Regional");
        center2.setDailyCapacity(50);
        centerRepository.save(center2);

        ImmigrationOfficer officer1=new ImmigrationOfficer();
        officer1.setFirstName("Ahmed");
        officer1.setLastName("Ali");
        officerRepository.save(officer1);
        ImmigrationOfficer officer2=new ImmigrationOfficer();
        officer2.setFirstName("Sara");
        officer2.setLastName("Mohammed");
        BorderControlOffice officer3=new BorderControlOffice();
        officer3.setFirstName("Khalid");
        officer3.setLastName("Hassan");
        officerRepository.save(officer3);

        Applicant applicant1=new Applicant();
        applicant1.setFirstName("John");
        applicant1.setLastName("Smith");
        applicantRepository.save(applicant1);
        Applicant applicant2=new Applicant();
        applicant2.setFirstName("David");
        applicant2.setLastName("Brown");
        applicant2.setCriminalRecord(true);
        applicantRepository.save(applicant2);
        Applicant applicant3=new Applicant();
        applicant3.setFirstName("Mona");
        applicant3.setLastName("Ali");
        applicantRepository.save(applicant3);
        AsylumSeeker applicant4=new AsylumSeeker();
        applicant4.setFirstName("Omar");
        applicant4.setLastName("Yousef");
        applicantRepository.save(applicant4);

        return "Database Seeded SUCCESSFULLY...";
    }
}
