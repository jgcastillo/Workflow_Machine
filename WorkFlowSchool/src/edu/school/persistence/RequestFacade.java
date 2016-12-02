package edu.school.persistence;

import edu.school.entities.Request;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class RequestFacade extends AbstractFacade<Request>{

    public RequestFacade() {
        super(Request.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
