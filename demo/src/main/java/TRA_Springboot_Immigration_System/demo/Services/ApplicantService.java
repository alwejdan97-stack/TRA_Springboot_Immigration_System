package TRA_Springboot_Immigration_System.demo.Services;


import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Repositories.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {
    ApplicantRepository applicantRepository;

    @Autowired

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant saveApplicant(Applicant applicant){
        return applicantRepository.save(applicant);
    }

    //create and save a new applicant object from strings
    public List<Applicant> saveApplicant(String firstName, String lastName, String passportNumber, String nationality)throws Exception{
        List<Applicant> applicants=new ArrayList<>();
        if(passportNumber==null || passportNumber.isEmpty()){
            throw new Exception("Passport Number Can't be Null");
        }
        for(Applicant a:applicants){
            if(!a.getFirstName().equalsIgnoreCase(firstName) && !a.getLastName().equalsIgnoreCase(lastName)){
                a.setFirstName(firstName);
                a.setLastName(lastName);
                a.setPassportNumber(passportNumber);
                a.setNationality(nationality);
                applicantRepository.save(a);
            }
            else{
                throw new Exception("Applicant Name is Already Exist...");
            }
        }
        return applicants;
    }
}
