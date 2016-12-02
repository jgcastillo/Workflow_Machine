package edu.school.persistence;

import edu.school.entities.ActivityTarget;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class ActivityTargetFacade extends AbstractFacade<ActivityTarget> {

    public ActivityTargetFacade() {
        super(ActivityTarget.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
}
