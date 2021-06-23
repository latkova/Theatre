package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.TheatreStageDao;
import mate.academy.spring.model.TheatreStage;
import mate.academy.spring.service.TheatreStageService;
import org.springframework.stereotype.Service;

@Service
public class TheatreStageServiceImpl implements TheatreStageService {
    private final TheatreStageDao theatreStageDao;

    public TheatreStageServiceImpl(TheatreStageDao theatreStageDao) {
        this.theatreStageDao = theatreStageDao;
    }

    @Override
    public TheatreStage add(TheatreStage theatreStage) {
        return theatreStageDao.add(theatreStage);
    }

    @Override
    public TheatreStage get(Long id) {
        return theatreStageDao.get(id).get();
    }

    @Override
    public List<TheatreStage> getAll() {
        return theatreStageDao.getAll();
    }
}
