package TRA_Springboot_Immigration_System.demo.Services;


import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Exceptions.ApplicantException;
import TRA_Springboot_Immigration_System.demo.Exceptions.ErrorMessages;
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
        if(applicant==null ||(applicant.getFirstName()==null&&applicant.getLastName()==null)){
            throw ApplicantException.badRequest(ErrorMessages.INVALID_DATA);
        }
        applicant.setCriminalRecord(true);
        return applicantRepository.save(applicant);
    }

    //create and save a new applicant object from strings
    public List<Applicant> saveApplicant(String firstName, String lastName, String passportNumber, String nationality){
        if(passportNumber==null || passportNumber.isEmpty()){
            throw ApplicantException.badRequest(ErrorMessages.INVALID_DATA);
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
                throw ApplicantException.badRequest(ErrorMessages.APPLICANT_NAME_CANNOT_BE_SAME_AS_PREVIOUS);
            }
        }
        return applicants;
    }

    //find applicant using criminalRecord
    public Applicant flagCriminalRecord(Long applicantId){
        for(Applicant a:applicants){
            if(applicantRepository.existsById(applicantId)){
                a.setCriminalRecord(true);
                return applicantRepository.findApplicantById(applicantId);
            }
        }
        throw ApplicantException.badRequest(ErrorMessages.APPLICANT_NOT_FOUND);
    }
}
