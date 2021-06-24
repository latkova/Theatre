package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.model.TheatreStage;

public interface TheatreStageService {
    TheatreStage add(TheatreStage theatreStage);

    TheatreStage get(Long id);

    List<TheatreStage> getAll();
}
