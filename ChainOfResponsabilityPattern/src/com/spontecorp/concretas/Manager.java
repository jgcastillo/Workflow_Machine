package com.spontecorp.concretas;

import com.spontecorp.api.Approver;
import com.spontecorp.api.LeaveRequest;

public class Manager extends Approver {

	@Override
        public void approveRequest(LeaveRequest request) {
		if (request.getDays() <= 15 && request.getDays() > 5) {
			System.out.println("Leave request approved for " + request.getDays() + " days by Manager");
		} else {
			super.approveRequest(request);
		}

	}
}
