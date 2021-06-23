package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.TheatreStage;
import mate.academy.spring.model.dto.request.TheatreStageRequestDto;
import mate.academy.spring.model.dto.response.TheatreStageResponseDto;
import mate.academy.spring.service.TheatreStageService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre-stages")
public class TheatreStageController {
    private final TheatreStageService theatreStageService;
    private final DtoRequestMapper<TheatreStageRequestDto, TheatreStage>
            theatreStageDtoRequestMapper;
    private final DtoResponseMapper<TheatreStageResponseDto, TheatreStage>
            theatreStageDtoResponseMapper;

    public TheatreStageController(TheatreStageService theatreStageService,
                                  DtoRequestMapper<TheatreStageRequestDto,
                                  TheatreStage> theatreStageDtoRequestMapper,
                                  DtoResponseMapper<TheatreStageResponseDto,
                                  TheatreStage> theatreStageDtoResponseMapper) {
        this.theatreStageService = theatreStageService;
        this.theatreStageDtoRequestMapper = theatreStageDtoRequestMapper;
        this.theatreStageDtoResponseMapper = theatreStageDtoResponseMapper;
    }

    @PostMapping
    public TheatreStageResponseDto addTheatreStage(@RequestBody TheatreStageRequestDto dto) {
        TheatreStage theatreStage = theatreStageService.add(theatreStageDtoRequestMapper
                .fromDto(dto));
        return theatreStageDtoResponseMapper.toDto(theatreStage);
    }

    @GetMapping
    public List<TheatreStageResponseDto> getAllTheatreStages() {
        return theatreStageService.getAll().stream()
                .map(theatreStageDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
