package mate.academy.spring.service;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.model.PerformanceSession;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    PerformanceSession get(Long id);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession update(PerformanceSession performanceSession);

    boolean remove(Long id);
}
