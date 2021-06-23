package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.Performance;
import mate.academy.spring.model.dto.request.PerformanceRequestDto;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceRequestMapper implements DtoRequestMapper<PerformanceRequestDto,
        Performance> {
    @Override
    public Performance fromDto(PerformanceRequestDto dto) {
        Performance performance = new Performance();
        performance.setTitle(dto.getTitle());
        performance.setDescription(dto.getDescription());
        return performance;
    }
}
