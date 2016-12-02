package edu.school.persistence;

import edu.school.entities.RequestAction;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class RequestActionFacade extends AbstractFacade<RequestAction> {

    public RequestActionFacade() {
        super(RequestAction.class);
    }

    @Override
        protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
}
