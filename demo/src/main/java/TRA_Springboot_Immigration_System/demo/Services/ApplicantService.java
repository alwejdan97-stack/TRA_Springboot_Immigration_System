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
    public static List<Applicant> applicants=new ArrayList<>();

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant saveApplicant(Applicant applicant){
        return applicantRepository.save(applicant);
    }

    //create and save a new applicant object from strings
    public List<Applicant> saveApplicant(String firstName, String lastName, String passportNumber, String nationality)throws RuntimeException{
        if(passportNumber==null || passportNumber.isEmpty()){
            throw new RuntimeException("Passport Number Can't be Null");
        }
        for(Applicant a:applicants){
            if(!applicantRepository.existFirstNameLastName(firstName,lastName)){
                a.setFirstName(firstName);
                a.setLastName(lastName);
                a.setPassportNumber(passportNumber);
                a.setNationality(nationality);
                applicantRepository.save(a);
            }
            else{
                throw new RuntimeException("Applicant Name is Already Exist...");
            }
        }
        return applicants;
    }

    //find applicant using criminalRecord
    public Applicant flagCriminalRecord(Long applicantId)throws RuntimeException{
        for(Applicant a:applicants){
            if(applicantRepository.existsById(applicantId)){
                a.setCriminalRecord(true);
                return applicantRepository.findApplicantById(applicantId);
            }
        }
        throw new RuntimeException("Applicant With ID "+applicantId+" NOT Found...");
    }
}
