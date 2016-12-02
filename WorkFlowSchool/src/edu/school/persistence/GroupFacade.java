package edu.school.persistence;

import edu.school.entities.Group;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class GroupFacade extends AbstractFacade<Group>{

    public GroupFacade() {
        super(Group.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
