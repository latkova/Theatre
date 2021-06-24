package mate.academy.spring.service.dto.mapping.impl.response;

import mate.academy.spring.model.Performance;
import mate.academy.spring.model.dto.response.PerformanceResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceResponseMapper implements DtoResponseMapper<PerformanceResponseDto,
        Performance> {
    @Override
    public PerformanceResponseDto toDto(Performance performance) {
        PerformanceResponseDto movieResponseDto = new PerformanceResponseDto();
        movieResponseDto.setId(performance.getId());
        movieResponseDto.setTitle(performance.getTitle());
        movieResponseDto.setDescription(performance.getDescription());
        return movieResponseDto;
    }
}
