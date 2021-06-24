package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.PerformanceSession;
import mate.academy.spring.model.dto.request.PerformanceSessionRequestDto;
import mate.academy.spring.model.dto.response.PerformanceSessionResponseDto;
import mate.academy.spring.service.PerformanceSessionService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    private final PerformanceSessionService performanceSessionService;
    private final DtoRequestMapper<PerformanceSessionRequestDto, PerformanceSession>
            performanceSessionDtoRequestMapper;
    private final DtoResponseMapper<PerformanceSessionResponseDto, PerformanceSession>
            performanceSessionDtoResponseMapper;

    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                               DtoRequestMapper<PerformanceSessionRequestDto, PerformanceSession>
                                          dtoRequestMapper,
                               DtoResponseMapper<PerformanceSessionResponseDto, PerformanceSession>
                                          dtoResponseMapper) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionDtoRequestMapper = dtoRequestMapper;
        this.performanceSessionDtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping
    public PerformanceSessionResponseDto addMovieSession(@RequestBody
                             PerformanceSessionRequestDto dto) {
        PerformanceSession performanceSession
                = performanceSessionService.add(performanceSessionDtoRequestMapper.fromDto(dto));
        return performanceSessionDtoResponseMapper.toDto(performanceSession);
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> getAllAvailableSessions(@RequestParam Long id,
                                                                       @RequestParam
                                                          @DateTimeFormat(pattern = "dd.MM.yyyy")
                                                            LocalDate date) {
        return performanceSessionService.findAvailableSessions(id, date).stream()
                .map(performanceSessionDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody PerformanceSessionRequestDto movieSessionRequestDto) {
        PerformanceSession performanceSession = performanceSessionDtoRequestMapper
                .fromDto(movieSessionRequestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceSessionService.remove(id);
    }
}
