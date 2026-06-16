package TRA_Springboot_Immigration_System.demo.Services;

import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationCenter;
import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import TRA_Springboot_Immigration_System.demo.Exceptions.ErrorMessages;
import TRA_Springboot_Immigration_System.demo.Exceptions.OfficerException;
import TRA_Springboot_Immigration_System.demo.Repositories.CenterRepository;
import TRA_Springboot_Immigration_System.demo.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficerService {
    OfficerRepository officerRepository;
    CenterRepository centerRepository;

    @Autowired

    public OfficerService(OfficerRepository officerRepository, CenterRepository centerRepository) {
        this.officerRepository = officerRepository;
        this.centerRepository = centerRepository;
    }

    //update the rank and clearance level
    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel){
        ImmigrationOfficer officer=officerRepository.findById(officerId).get();
        if(officer.getId()==officerId){
            if(newClearanceLevel>=1 && newClearanceLevel<=5){
                officer.setClearanceLevel(newClearanceLevel);
                officer.setClearanceLevel(newClearanceLevel);
                return officerRepository.save(officer);
            }
        }
        //throw OfficerException.badRequest(ErrorMessages.OFFICER_NOT_FOUND);
        throw OfficerException.notFound(officerId);

    }

    //changes the officer assigned center
    public ImmigrationOfficer transferOfficer(Long officerId,Long newCenterId){
        ImmigrationOfficer officer=officerRepository.findById(officerId).get();
        ImmigrationCenter center=centerRepository.findById(newCenterId).get();
        if(officer.getId()==officerId){
            officer.setId(newCenterId);
            return officerRepository.save(officer);
        }
        //throw OfficerException.badRequest(ErrorMessages.OFFICER_NOT_FOUND);
        throw OfficerException.notFound(officerId);
    }

    public List<ImmigrationOfficer> findByRank(String rank){
        if(rank!=null || !rank.isEmpty()){
            return officerRepository.findByRank(rank);
        }
        throw OfficerException.badRequest(ErrorMessages.INVALID_DATA);
    }

    public List<ImmigrationOfficer> findByRank(String rank, int minimumClearanceLevel){
        if(rank!=null || !rank.isEmpty()){
            return officerRepository.findByRank(rank,minimumClearanceLevel);
        }
        throw OfficerException.badRequest(ErrorMessages.INVALID_DATA);
    }

}
