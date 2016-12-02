package edu.school.test;

/**
 * Clase que maneja el requerimiento
 * @author jgcastillo
 */
public class Approver {
    
    protected Approver nextApprover;

    public void approveRequest(Request request) {
        nextApprover.approveRequest(request);
    }

    public void setNext(Approver approver) {
        this.nextApprover = approver;
    }
}
