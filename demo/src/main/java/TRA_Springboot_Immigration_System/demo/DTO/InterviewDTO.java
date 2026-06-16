package TRA_Springboot_Immigration_System.demo.DTO;

import TRA_Springboot_Immigration_System.demo.Entities.Applicant;
import TRA_Springboot_Immigration_System.demo.Entities.Interview;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class InterviewDTO {
    private long id;
    private String interviewDate;
    private String status;
    private String purpose;

    public static InterviewDTO convertToDTO(Interview entity) {
        InterviewDTO dto = new InterviewDTO();
        dto.setId(entity.getId());
        dto.setInterviewDate(entity.getInterviewDate());
        dto.setPurpose(entity.getPurpose());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<InterviewDTO> convertToDTO(List<Interview> entities) {
        List<InterviewDTO> dtos = new ArrayList<>();
        for (Interview entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}
