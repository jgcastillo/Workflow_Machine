package edu.school.persistence;

import edu.school.entities.Process;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class ProcessFacade extends AbstractFacade<Process>{

    public ProcessFacade() {
        super(Process.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }

}
