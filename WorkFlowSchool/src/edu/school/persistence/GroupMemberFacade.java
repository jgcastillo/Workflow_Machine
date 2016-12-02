package edu.school.persistence;

import edu.school.entities.GroupMember;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

public class GroupMemberFacade extends AbstractFacade<GroupMember>{

    public GroupMemberFacade() {
        super(GroupMember.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
