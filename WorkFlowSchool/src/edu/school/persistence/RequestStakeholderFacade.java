package edu.school.persistence;

import edu.school.entities.RequestStakeholder;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class RequestStakeholderFacade extends AbstractFacade<RequestStakeholder>{

    public RequestStakeholderFacade() {
        super(RequestStakeholder.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
