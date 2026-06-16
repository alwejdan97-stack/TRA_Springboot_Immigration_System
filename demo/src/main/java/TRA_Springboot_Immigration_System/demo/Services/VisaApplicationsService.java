package TRA_Springboot_Immigration_System.demo.Services;

import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import TRA_Springboot_Immigration_System.demo.Entities.VisaApplications;
import TRA_Springboot_Immigration_System.demo.Exceptions.ApplicantException;
import TRA_Springboot_Immigration_System.demo.Exceptions.ErrorMessages;
import TRA_Springboot_Immigration_System.demo.Exceptions.OfficerException;
import TRA_Springboot_Immigration_System.demo.Exceptions.VisaApplicationException;
import TRA_Springboot_Immigration_System.demo.Repositories.ApplicantRepository;
import TRA_Springboot_Immigration_System.demo.Repositories.OfficerRepository;
import TRA_Springboot_Immigration_System.demo.Repositories.VisaApplicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaApplicationsService {
    VisaApplicationsRepository visaApplicationsRepository;
    ApplicantRepository applicantRepository;
    OfficerRepository officerRepository;

    @Autowired
    public VisaApplicationsService(VisaApplicationsRepository visaApplicationsRepository, ApplicantRepository applicantRepository, OfficerRepository officerRepository) {
        this.visaApplicationsRepository = visaApplicationsRepository;
        this.applicantRepository = applicantRepository;
        this.officerRepository = officerRepository;
    }

    public VisaApplications submissionApplication(Long applicantId, String visaType)throws RuntimeException{
        Applicant applicant=applicantRepository.findById(applicantId).get();
        VisaApplications application=new VisaApplications();
        if(applicant.getId()!=applicantId){
            application.setApplicant(applicant);
            application.setVisaType(visaType);
        }else{
            //throw new RuntimeException(ErrorMessages.APPLICANT_NOT_FOUND);
            throw ApplicantException.notFound(applicantId);

        }
        if(applicant.getCriminalRecord()==true){
            application.setStatus("REJECTED");
            application.setOfficerNotes("Auto-Rejected due to criminal flag.");
        }else{
            application.setStatus("PENDING");
        }
        return visaApplicationsRepository.save(application);
    }

    public VisaApplications assignedOfficer(Long visaId, Long officerId){
        VisaApplications application=visaApplicationsRepository.findById(visaId).get();
        ImmigrationOfficer officer=officerRepository.findById(officerId).get();
        if(!visaApplicationsRepository.existsById(visaId)){
            //throw VisaApplicationException.badRequest(ErrorMessages.VISA_APPLICATION_NOT_FOUND);
            throw VisaApplicationException.notFound(visaId);
        }
        if(!officerRepository.existsById(officerId)){
            //throw OfficerException.badRequest(ErrorMessages.OFFICER_NOT_FOUND);
            throw OfficerException.notFound(officerId);
        }
        if(application.getVisaType().equalsIgnoreCase("Asylum")){
            if(officer.getClearanceLevel()!=4 || officer.getClearanceLevel()!=5){
                throw OfficerException.badRequest(ErrorMessages.FAILED_VALIDATION);
            }
        }
        application.setHandlingOfficer(officer);
        return visaApplicationsRepository.save(application);
    }

    public VisaApplications processVisa(Long visaId, String newStatus, String notes){
        VisaApplications applications=visaApplicationsRepository.findById(visaId).get();
        if(applications.getId()==visaId){
            applications.setStatus("APPROVED");
            applications.setOfficerNotes(notes);
        }else{
            throw VisaApplicationException.notFound(visaId);
        }
        return visaApplicationsRepository.save(applications);
    }
}
