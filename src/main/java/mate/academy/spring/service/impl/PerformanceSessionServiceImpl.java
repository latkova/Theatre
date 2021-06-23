package mate.academy.spring.service.impl;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.dao.PerformanceSessionDao;
import mate.academy.spring.model.PerformanceSession;
import mate.academy.spring.service.PerformanceSessionService;
import org.springframework.stereotype.Service;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao sessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date) {
        return sessionDao.findAvailableSessions(performanceId, date);
    }

    @Override
    public PerformanceSession get(Long id) {
        return sessionDao.get(id).get();
    }

    @Override
    public PerformanceSession add(PerformanceSession session) {
        return sessionDao.add(session);
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        return sessionDao.update(performanceSession);
    }

    @Override
    public boolean remove(Long id) {
        return sessionDao.remove(id);
    }
}
