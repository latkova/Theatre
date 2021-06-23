package mate.academy.spring.service.dto.mapping.impl.response;

import mate.academy.spring.model.TheatreStage;
import mate.academy.spring.model.dto.response.TheatreStageResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class TheatreStageResponseMapper implements DtoResponseMapper<TheatreStageResponseDto,
        TheatreStage> {
    @Override
    public TheatreStageResponseDto toDto(TheatreStage theatreStage) {
        TheatreStageResponseDto theatreStageResponseDto = new TheatreStageResponseDto();
        theatreStageResponseDto.setId(theatreStage.getId());
        theatreStageResponseDto.setCapacity(theatreStage.getCapacity());
        return theatreStageResponseDto;
    }
}
