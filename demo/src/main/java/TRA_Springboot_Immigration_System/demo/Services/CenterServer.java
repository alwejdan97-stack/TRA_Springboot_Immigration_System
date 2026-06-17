package TRA_Springboot_Immigration_System.demo.Services;

import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationCenter;
import TRA_Springboot_Immigration_System.demo.Exceptions.CenterException;
import TRA_Springboot_Immigration_System.demo.Exceptions.ErrorMessages;
import TRA_Springboot_Immigration_System.demo.Repositories.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CenterServer {
    CenterRepository centerRepository;
    @Autowired
    public CenterServer(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public ImmigrationCenter saveCenter(ImmigrationCenter center){
        return centerRepository.save(center);
    }

    public ImmigrationCenter findByCenterId(Long centerId){
        ImmigrationCenter center = centerRepository.findById(centerId).get();
        if(!centerRepository.existsById(centerId)){
            throw CenterException.notFound(centerId);
        }
        return center;
    }
    public List<ImmigrationCenter> findByCenterName(String centerName){
        List<ImmigrationCenter> centers=centerRepository.findByName(centerName);
        if(!centers.isEmpty()){
            return centerRepository.findByName(centerName);
        }
        throw CenterException.badRequest(ErrorMessages.CENTER_NAME_NOT_FOUND);
    }
}
