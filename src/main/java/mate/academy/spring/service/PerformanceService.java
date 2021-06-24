package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.model.Performance;

public interface PerformanceService {
    Performance add(Performance performance);

    Performance get(Long id);

    List<Performance> getAll();
}
