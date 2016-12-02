package edu.school.test;

/**
 * Manejador de primer nivel
 * @author jgcastillo
 */
public class Supervisor extends Approver{

    @Override
    public void approveRequest(Request request) {

        if (request.getDays() <= 5) {
            System.out.println("Leave request approved for " + request.getDays() + " days by Supervisor");
        } else {
            super.approveRequest(request);
        }

    }
    
}
