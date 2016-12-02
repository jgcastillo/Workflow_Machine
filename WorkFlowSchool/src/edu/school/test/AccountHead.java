package edu.school.test;

/**
 *
 * @author jgcastillo
 */
public class AccountHead extends Approver {

    @Override
    public void approveRequest(Request request) {
        if (request.getDays() > 15) {
            System.out.println("Leave request approved for " + request.getDays() + " days by AccountHead");
        } else {
            super.approveRequest(request);
        }

    }
}
