package edu.school.persistence;

import edu.school.entities.ProcessAdmin;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class ProcessAdminFacade extends AbstractFacade<ProcessAdmin>{

    public ProcessAdminFacade() {
        super(ProcessAdmin.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }

}
