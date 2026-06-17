package TRA_Springboot_Immigration_System.demo.DTO;

import TRA_Springboot_Immigration_System.demo.Entities.ImmigrationCenter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CenterDTO {
    private long id;
    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;

    public static CenterDTO convertToDTO(ImmigrationCenter entity) {
        CenterDTO dto = new CenterDTO();
        dto.setId(entity.getId());
        dto.setDailyCapacity(entity.getDailyCapacity());
        dto.setLocationCountry(entity.getLocationCountry());
        dto.setType(entity.getType());
        dto.setName(entity.getName());
        return dto;
    }

    public static List<CenterDTO> convertToDTO(List<ImmigrationCenter> entities) {
        List<CenterDTO> dtos = new ArrayList<>();
        for (ImmigrationCenter entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}
