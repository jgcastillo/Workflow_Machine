package edu.school.persistence;

import edu.school.entities.State;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class StateFacade extends AbstractFacade<State>{

    public StateFacade() {
        super(State.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
