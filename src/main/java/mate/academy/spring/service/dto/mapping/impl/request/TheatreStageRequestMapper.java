package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.TheatreStage;
import mate.academy.spring.model.dto.request.TheatreStageRequestDto;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class TheatreStageRequestMapper implements DtoRequestMapper<TheatreStageRequestDto,
        TheatreStage> {
    @Override
    public TheatreStage fromDto(TheatreStageRequestDto dto) {
        TheatreStage theatreStage = new TheatreStage();
        theatreStage.setCapacity(dto.getCapacity());
        theatreStage.setDescription(dto.getDescription());
        return theatreStage;
    }
}
