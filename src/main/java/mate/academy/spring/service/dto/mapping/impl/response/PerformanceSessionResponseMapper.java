package mate.academy.spring.service.dto.mapping.impl.response;

import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.PerformanceSession;
import mate.academy.spring.model.dto.response.PerformanceSessionResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionResponseMapper implements
        DtoResponseMapper<PerformanceSessionResponseDto,
        PerformanceSession> {
    public static final String PATTERN = "dd.MM.yyyy HH:mm";

    @Override
    public PerformanceSessionResponseDto toDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto performanceSessionResponseDto =
                new PerformanceSessionResponseDto();
        performanceSessionResponseDto.setId(performanceSession.getId());
        performanceSessionResponseDto.setPerformanceTitle(performanceSession.getMovie().getTitle());
        performanceSessionResponseDto.setShowTime(performanceSession.getShowTime()
                                            .format(DateTimeFormatter
                                                    .ofPattern(PATTERN)));
        performanceSessionResponseDto.setCinemaHallCapacity(performanceSession.getCinemaHall()
                .getCapacity());
        return performanceSessionResponseDto;
    }
}
