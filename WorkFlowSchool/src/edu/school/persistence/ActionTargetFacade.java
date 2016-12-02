package edu.school.persistence;

import edu.school.entities.ActionTarget;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class ActionTargetFacade extends AbstractFacade<ActionTarget> {

    public ActionTargetFacade() {
        super(ActionTarget.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
}
