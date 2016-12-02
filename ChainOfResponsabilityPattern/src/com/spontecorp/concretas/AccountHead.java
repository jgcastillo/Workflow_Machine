package com.spontecorp.concretas;

import com.spontecorp.api.Approver;
import com.spontecorp.api.LeaveRequest;

public class AccountHead extends Approver {

    @Override
    public void approveRequest(LeaveRequest request) {
        if (request.getDays() > 15) {
            System.out.println("Leave request approved for " + request.getDays() + " days by AccountHead");
        } else {
            super.approveRequest(request);
        }

    }
}
