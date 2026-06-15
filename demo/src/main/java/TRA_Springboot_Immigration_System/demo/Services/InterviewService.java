package TRA_Springboot_Immigration_System.demo.Services;


import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import TRA_Springboot_Immigration_System.demo.Entities.Interview;
import TRA_Springboot_Immigration_System.demo.Repositories.ApplicantRepository;
import TRA_Springboot_Immigration_System.demo.Repositories.InterviewRepository;
import TRA_Springboot_Immigration_System.demo.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    InterviewRepository interviewRepository;
    OfficerRepository officerRepository;
    ApplicantRepository applicantRepository;

    @Autowired
    public InterviewService(InterviewRepository interviewRepository, OfficerRepository officerRepository,ApplicantRepository applicantRepository) {
        this.interviewRepository = interviewRepository;
        this.officerRepository = officerRepository;
        this.applicantRepository=applicantRepository;
    }

    public Interview scheduleInterview(Long applicantId, Long officerId, String date){
        Applicant applicant=applicantRepository.findById(applicantId).get();
        ImmigrationOfficer officer=officerRepository.findById(officerId).get();
        if(!officerRepository.existsById(officerId)){
            throw new RuntimeException("Officer With ID "+officerId+" NOT Found...");
        }
        if(!applicantRepository.existsById(applicantId)){
            throw new RuntimeException("Applicant With ID "+applicantId+" NOT Found...");
        }
        List<Interview> interviewList=interviewRepository.findByOfficerIdAndInterviewDate(officerId,date);
        if(interviewList.isEmpty()){
            Interview interview=new Interview();
            interview.setApplicant(applicant);
            interview.setOfficer(officer);
            interview.setInterviewDate(date);
            interview.setStatus("SCHEDULE");
            return interviewRepository.save(interview);
        }else{
            throw new RuntimeException("Officer is double-booked!");
        }
    }

    public Interview completeInterview(Long interviewId){
        Interview interview=interviewRepository.findById(interviewId).get();
        if(interviewRepository.existsById(interviewId)){
            interview.setStatus("COMPLETE");
            return interviewRepository.save(interview);
        }
        throw new RuntimeException("Interview With ID "+interviewId+" NOT Found...");
    }
}
