package edu.school.test;

import edu.school.api.ControllerIntf;
import edu.school.controller.Controller;
import edu.school.entities.Process;
import edu.school.entities.ProcessAdmin;
import edu.school.entities.Request;
import edu.school.entities.RequestData;
import edu.school.entities.RequestStakeholder;
import edu.school.entities.State;
import edu.school.entities.Transition;
import edu.school.entities.User;
import edu.school.utilities.DateUtilities;
import edu.school.utilities.StateTypeEnum;
import java.time.LocalDate;
import java.util.Date;

public class TestWFS {
    public static void main(String[] args) {
        ControllerIntf controller = new Controller();
        
        // se crea un usuario y un proceso
        Date birthdayDate = DateUtilities.localDateToDate(LocalDate.of(1975, 1, 12));
        User user = controller.createUser("Juan", "Dorta", birthdayDate);
        birthdayDate = DateUtilities.localDateToDate(LocalDate.of(1963, 5, 22));
        User stakeHolder = controller.createUser("Pedro", "Perez", birthdayDate);
        Process process = controller.createProcess("Primer proceso");
        
        // se asigna el proceso al usuario 
        ProcessAdmin prcAdmin = controller.assignAdmin(process, user);
        System.out.println("Asignación realizada. " + prcAdmin.toString());

        // se crea el requerimiento en su estado inicial
        String stateType = StateTypeEnum.START.stateTypeName();
        State currentState = controller.createState(stateType, process, 
                "Estado inicial del proceso", "");
        
        // con la data inicial se crea el requerimiento
        Date dateRequested = new Date();
        Request request = controller.createRequest("primer requerimiento", 
                dateRequested, process, currentState, user);
        RequestData requestData = controller.createRequestData("uno", 
                "la primera data que se asigna a este requerimiento", request);
        System.out.println("Requerimiento creado " + request.getTitle());
        
        // se le asigna un interesado (stakeholder)
        RequestStakeholder requestStakeholder = controller
                .createRequestStackeholder(request, stakeHolder);
        System.out.println("Se le asigna un interesado " + stakeHolder.getLastName());
        
        // El proceso cambio de un stado a otro
        State nextState = controller
                .createState(StateTypeEnum.NORMAL.stateTypeName(), process,
                        "Paso a Normal", "");
        
        // ahora se hace la transición:
        Transition transition = controller.createTransition(process, 
                currentState, nextState);
        System.out.println("El proceso " + transition.getProcessId().getName()
                + " paso de " + transition.getCurrentStateId().getName()
                + " a " + transition.getNextStateId().getName());
        
    }
    
}
