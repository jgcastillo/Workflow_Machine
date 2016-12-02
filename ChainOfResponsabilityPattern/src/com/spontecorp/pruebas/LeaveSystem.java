package com.spontecorp.pruebas;

import com.spontecorp.api.Approver;
import com.spontecorp.api.LeaveRequest;
import com.spontecorp.concretas.AccountHead;
import com.spontecorp.concretas.Manager;
import com.spontecorp.concretas.SuperVisor;

public class LeaveSystem {
    public static void main(String[] args) {

        Approver supervisor = new SuperVisor();
        Approver manager = new Manager();
        Approver accountHead = new AccountHead();

        supervisor.setNext(manager);
        manager.setNext(accountHead);

        supervisor.approveRequest(new LeaveRequest(4));
        supervisor.approveRequest(new LeaveRequest(40));
        supervisor.approveRequest(new LeaveRequest(12));

    }

}
