package edu.school.test;

import edu.school.api.ControllerIntf;
import edu.school.controller.Controller;
import edu.school.entities.Action;
import edu.school.entities.Group;
import edu.school.entities.GroupMember;
import edu.school.entities.Process;
import edu.school.entities.Request;
import edu.school.entities.RequestAction;
import edu.school.entities.State;
import edu.school.entities.Transition;
import edu.school.entities.TransitionAction;
import edu.school.entities.User;
import edu.school.utilities.ActionTypeEnum;
import edu.school.utilities.DateUtilities;
import edu.school.utilities.StateTypeEnum;
import java.time.LocalDate;
import java.util.Date;

public class TestWFS {
    public static void main(String[] args) {
        ControllerIntf controller = new Controller();
        
        Process firstProcess = controller.createProcess("first process");

        // se crean tres usuarios
        User jane = controller.createUser("Jane", "Sponte1", 
                DateUtilities.localDateToDate(LocalDate.of(1965, 7, 14)));
        User tom = controller.createUser("Tom", "Sponte2",
                DateUtilities.localDateToDate(LocalDate.of(1973, 4, 19)));
        User gary = controller.createUser("Gary", "Sponte3",
                DateUtilities.localDateToDate(LocalDate.of(1975, 10, 5)));
        
        // se crea un grupo
        Group excutives = controller.createGroup(firstProcess, "excutives");
        // se agregan tom y gary al grupo
        GroupMember groupMember1 = controller.createGroupMember(excutives, gary);
        GroupMember groupMember2 = controller.createGroupMember(excutives, tom);
        
        // se crean varios estados
        State stateA = controller.createState(StateTypeEnum.START.name(), 
                firstProcess, "stateA", "");
        State stateB = controller.createState(StateTypeEnum.NORMAL.name(),
                firstProcess, "stateB", "");
        State stateC = controller.createState(StateTypeEnum.DENIED.name(),
                firstProcess, "stateC", "");
        
        // se realizan varias transiciones
        // A pasa a B
        Transition transitionA = controller.createTransition(firstProcess, 
                stateA, stateB);
        // A pasa a C
        Transition transitionB = controller.createTransition(firstProcess, 
                stateA, stateC);
        // B pasa a C
        Transition transitionC = controller.createTransition(firstProcess, 
                stateB, stateC);
        
        // se realizan acciones de acuerdo a la transición
        Action aprovedByRequester = controller
                .createAction(ActionTypeEnum.APPROVE.name(), firstProcess, 
                        "Aproved By Requester", "");
        Action aprovedByExecutives = controller
                .createAction(ActionTypeEnum.APPROVE.name(), firstProcess, 
                        "Aproved By Executives", "");
        Action deniedByExecutives = controller
                .createAction(ActionTypeEnum.DENY.name(), firstProcess, 
                        "Denied By Executives", "");
        Action deniedByRequester = controller.createAction(ActionTypeEnum.DENY.name(),
                firstProcess, "Denied By Requester", "");
        
        
        TransitionAction ta1 = controller.createTransitionAction(transitionA, aprovedByRequester);
        TransitionAction ta2 = controller.createTransitionAction(transitionA, aprovedByExecutives);
        TransitionAction ta3 = controller.createTransitionAction(transitionB, deniedByExecutives);
        TransitionAction ta4 = controller.createTransitionAction(transitionC, deniedByExecutives);
        
        Request janeRequest = controller.createRequest("Jane´s Request", 
                new Date(), firstProcess, stateA, jane);
        
        RequestAction ra1 = controller.createRequestAction(janeRequest, aprovedByRequester, transitionA, 1, 0);
        RequestAction ra2 = controller.createRequestAction(janeRequest, aprovedByExecutives, transitionA, 1, 0);
        RequestAction ra3 = controller.createRequestAction(janeRequest, aprovedByExecutives, transitionA, 1, 0);
        
    }
    
}
