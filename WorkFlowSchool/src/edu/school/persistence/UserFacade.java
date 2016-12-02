package edu.school.persistence;

import edu.school.entities.User;
import edu.school.utilities.JpaUtilities;
import javax.persistence.EntityManager;

/**
 *
 * @author jgcastillo
 */
public class UserFacade extends AbstractFacade<User>{

    public UserFacade() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return JpaUtilities.getEMF().createEntityManager();
    }
    
}
