package edu.school.persistence;

import edu.school.entities.Activity;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class ActivityFacade extends AbstractFacade<Activity>{

    public ActivityFacade() {
        super(Activity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
