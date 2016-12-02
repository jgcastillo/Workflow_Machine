package edu.school.persistence;

import edu.school.entities.Target;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class TargetFacade extends AbstractFacade<Target> {

    public TargetFacade() {
        super(Target.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
}
