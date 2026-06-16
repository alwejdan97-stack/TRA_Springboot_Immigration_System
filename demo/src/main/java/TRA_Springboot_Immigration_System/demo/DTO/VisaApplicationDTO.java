package TRA_Springboot_Immigration_System.demo.DTO;

import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationOfficer;
import TRA_Springboot_Immigration_System.demo.Entities.VisaApplications;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class VisaApplicationDTO {
    private long id;
    private String visaType;
    private String status;
    private String officerNotes;

    public static VisaApplicationDTO convertToDTO(VisaApplications entity) {
        VisaApplicationDTO dto = new VisaApplicationDTO();
        dto.setId(entity.getId());
        dto.setVisaType(entity.getVisaType());
        dto.setStatus(entity.getStatus());
        dto.setOfficerNotes(entity.getOfficerNotes());
        return dto;
    }

    public static List<VisaApplicationDTO> convertToDTO(List<VisaApplications> entities) {
        List<VisaApplicationDTO> dtos = new ArrayList<>();
        for (VisaApplications entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}
