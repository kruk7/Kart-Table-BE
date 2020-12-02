package utils;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Produces;

public class EntityManagerCreator {

    @PersistenceContext
    EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManager createEntityMenager(){
        return entityManager;
    }

}
