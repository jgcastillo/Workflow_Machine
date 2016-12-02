package edu.school.persistence;

import edu.school.entities.Transition;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class TransitionFacade extends AbstractFacade<Transition>{

    public TransitionFacade() {
        super(Transition.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
