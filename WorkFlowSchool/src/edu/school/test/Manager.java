package edu.school.test;

/**
 * Segundo nivel de aprobación
 * @author jgcastillo
 */
public class Manager extends Approver{
    @Override
    public void approveRequest(Request request) {
        if (request.getDays() <= 15 && request.getDays() > 5) {
            System.out.println("Leave request approved for " + request.getDays() + " days by Manager");
        } else {
            super.approveRequest(request);
        }

    }
}
