package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.Performance;

public interface PerformanceDao extends GenericDao<Performance> {
    Optional<Performance> get(Long id);

    List<Performance> getAll();
}
