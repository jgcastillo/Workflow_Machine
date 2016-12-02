package edu.school.test;

/**
 *
 * @author jgcastillo
 */
public class LeaveSystem {
    public static void main(String[] args) {

        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        Approver accountHead = new AccountHead();

        supervisor.setNext(manager);
        manager.setNext(accountHead);

        supervisor.approveRequest(new Request(4));
        supervisor.approveRequest(new Request(40));
        supervisor.approveRequest(new Request(12));

    }
}
