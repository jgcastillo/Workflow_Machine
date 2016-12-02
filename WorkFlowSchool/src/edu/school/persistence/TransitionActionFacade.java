package edu.school.persistence;

import edu.school.entities.TransitionAction;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class TransitionActionFacade extends AbstractFacade<TransitionAction>{

    public TransitionActionFacade() {
        super(TransitionAction.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
