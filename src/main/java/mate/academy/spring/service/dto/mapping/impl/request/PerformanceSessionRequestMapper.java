package mate.academy.spring.service.dto.mapping.impl.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mate.academy.spring.model.Performance;
import mate.academy.spring.model.PerformanceSession;
import mate.academy.spring.model.TheatreStage;
import mate.academy.spring.model.dto.request.PerformanceSessionRequestDto;
import mate.academy.spring.service.PerformanceService;
import mate.academy.spring.service.TheatreStageService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionRequestMapper implements
        DtoRequestMapper<PerformanceSessionRequestDto,
        PerformanceSession> {
    public static final String PATTERN = "dd.MM.yyyy HH:mm";
    private final TheatreStageService cinemaHallService;
    private final PerformanceService performanceService;

    public PerformanceSessionRequestMapper(TheatreStageService cinemaHallService,
                                           PerformanceService performanceService) {
        this.cinemaHallService = cinemaHallService;
        this.performanceService = performanceService;
    }

    @Override
    public PerformanceSession fromDto(PerformanceSessionRequestDto dto) {
        PerformanceSession performanceSession = new PerformanceSession();
        Performance performance = performanceService.get(dto.getPerformanceId());
        TheatreStage cinemaHall = cinemaHallService.get(dto.getCinemaHallId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        performanceSession.setPerformance(performance);
        performanceSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        performanceSession.setTheatreStage(cinemaHall);
        return performanceSession;
    }
}
