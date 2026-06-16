package TRA_Springboot_Immigration_System.demo.DTO;

import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import TRA_Springboot_Immigration_System.demo.Entities.Interview;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OfficerDTO {
    private long id;
    private String badgeNumber;
    private String rank;
    private int clearanceLevel;
    private Boolean active;

    public static OfficerDTO convertToDTO(ImmigrationOfficer entity) {
        OfficerDTO dto = new OfficerDTO();
        dto.setId(entity.getId());
        dto.setBadgeNumber(entity.getBadgeNumber());
        dto.setRank(entity.getRank());
        dto.setClearanceLevel(entity.getClearanceLevel());
        dto.setActive(entity.getActive());
        return dto;
    }

    public static List<OfficerDTO> convertToDTO(List<ImmigrationOfficer> entities) {
        List<OfficerDTO> dtos = new ArrayList<>();
        for (ImmigrationOfficer entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}
