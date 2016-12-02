package edu.school.persistence;

import edu.school.entities.Action;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class ActionFacade extends AbstractFacade<Action>{

    public ActionFacade() {
        super(Action.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
