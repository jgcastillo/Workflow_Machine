package edu.school.persistence;

import edu.school.entities.ActivityType;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class ActivityTypeFacade extends AbstractFacade<ActivityType>{

    public ActivityTypeFacade() {
        super(ActivityType.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
