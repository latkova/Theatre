package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.TheatreStageDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.TheatreStage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreStageDaoImpl extends AbstractDao<TheatreStage> implements TheatreStageDao {
    public TheatreStageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<TheatreStage> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(TheatreStage.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a Theatre Stage by id: " + id, e);
        }
    }

    @Override
    public List<TheatreStage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<TheatreStage> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(TheatreStage.class);
            criteriaQuery.from(TheatreStage.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all Theatre Stages", e);
        }
    }
}
