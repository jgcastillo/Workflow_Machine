package edu.school.persistence;

import edu.school.entities.RequestData;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class RequestDataFacade extends AbstractFacade<RequestData>{

    public RequestDataFacade() {
        super(RequestData.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
