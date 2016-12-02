package edu.school.utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtilities {
    private static final EntityManagerFactory EMF = 
            Persistence.createEntityManagerFactory("WorkFlowSchoolPU");

    public static EntityManagerFactory getEMF() {
        return EMF;
    }

    protected static void closeEMF() {
        if (EMF != null) {
            EMF.close();
        }
    }
}
