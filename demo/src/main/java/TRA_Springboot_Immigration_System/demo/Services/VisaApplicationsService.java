package TRA_Springboot_Immigration_System.demo.Services;

import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import TRA_Springboot_Immigration_System.demo.Entities.VisaApplications;
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
            throw new RuntimeException("Applicant With ID "+applicantId+ " NOT Found...");

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
            throw new RuntimeException("Visa Application With ID "+visaId+" NOT Found...");
        }
        if(!officerRepository.existsById(officerId)){
            throw new RuntimeException("Officer With ID "+officerId+" NOT Found...");
        }
        if(application.getVisaType().equalsIgnoreCase("Asylum")){
            if(officer.getClearanceLevel()!=4 || officer.getClearanceLevel()!=5){
                throw new RuntimeException("Validation Failed...");
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
        }
        return visaApplicationsRepository.save(applications);
    }
}
