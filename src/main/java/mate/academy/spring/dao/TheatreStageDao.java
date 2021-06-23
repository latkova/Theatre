package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.TheatreStage;

public interface TheatreStageDao extends GenericDao<TheatreStage> {
    Optional<TheatreStage> get(Long id);

    List<TheatreStage> getAll();
}
