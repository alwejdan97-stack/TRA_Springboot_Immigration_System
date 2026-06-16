package TRA_Springboot_Immigration_System.demo.Services;


import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import TRA_Springboot_Immigration_System.demo.Entities.Interview;
import TRA_Springboot_Immigration_System.demo.Exceptions.ApplicantException;
import TRA_Springboot_Immigration_System.demo.Exceptions.ErrorMessages;
import TRA_Springboot_Immigration_System.demo.Exceptions.InterviewException;
import TRA_Springboot_Immigration_System.demo.Exceptions.OfficerException;
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
            throw InterviewException.badRequest(ErrorMessages.INTERVIEW_NOT_FOUND);
        }
        if(!applicantRepository.existsById(applicantId)){
            throw ApplicantException.badRequest(ErrorMessages.APPLICANT_NOT_FOUND);
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
            throw OfficerException.badRequest(ErrorMessages.DOUBLE_BOOKED_OFFICER);
        }
    }

    public Interview completeInterview(Long interviewId){
        Interview interview=interviewRepository.findById(interviewId).get();
        if(interviewRepository.existsById(interviewId)){
            interview.setStatus("COMPLETE");
            return interviewRepository.save(interview);
        }
        throw InterviewException.badRequest(ErrorMessages.INTERVIEW_NOT_FOUND);
    }
}
