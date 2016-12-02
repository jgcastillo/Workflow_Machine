package edu.school.controller;

import edu.school.api.ControllerIntf;
import edu.school.entities.Process;
import edu.school.entities.ProcessAdmin;
import edu.school.entities.Request;
import edu.school.entities.RequestData;
import edu.school.entities.RequestStakeholder;
import edu.school.entities.State;
import edu.school.entities.Transition;
import edu.school.entities.User;
import edu.school.persistence.ProcessAdminFacade;
import edu.school.persistence.ProcessFacade;
import edu.school.persistence.RequestDataFacade;
import edu.school.persistence.RequestFacade;
import edu.school.persistence.RequestStakeholderFacade;
import edu.school.persistence.StateFacade;
import edu.school.persistence.TransitionFacade;
import edu.school.persistence.UserFacade;
import java.util.Date;

public class Controller implements ControllerIntf{

    @Override
    public User createUser(String firstName, String lastName, Date birthdayDate) {
        UserFacade userFacade = new UserFacade();
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateOfBirthday(birthdayDate);
        userFacade.create(user);
        return user;
    }

    @Override
    public Process createProcess(String name) {
        Process process = new Process();
        process.setName(name);
        ProcessFacade processFacade = new ProcessFacade();

        processFacade.create(process);
        return process;
    }

    @Override
    public Request createRequest(String title, Date dateRequested, 
            Process process, State currentState, User userId) {
        
        RequestFacade requestFacade = new RequestFacade();
        Request request = new Request();
        request.setTitle(title);
        request.setDateRequested(dateRequested);
        request.setProcessId(process);
        request.setCurrentStateId(currentState);
        request.setUserId(userId);
        
        requestFacade.create(request);
        return request;
    }

    @Override
    public ProcessAdmin assignAdmin(Process process, User user) {
        ProcessAdminFacade processAdminFacade = new ProcessAdminFacade();
        ProcessAdmin processAdmin = new ProcessAdmin();
        processAdmin.setProcessId(process);
        processAdmin.setUserId(user);
        
        processAdminFacade.create(processAdmin);
        return processAdmin;
    }

    @Override
    public State createState(String stateType, Process process, String name, 
            String description) {
        StateFacade stateFacade = new StateFacade();
        State state = new State();
        state.setName(name);
        state.setDescription(description);
        state.setProcessId(process);
        state.setStateType(stateType);
        
        stateFacade.create(state);
        return state;
    }

    @Override
    public RequestData createRequestData(String name, String value, 
            Request requestId) {
        RequestDataFacade requestDataFacade = new RequestDataFacade();
        RequestData requestData = new RequestData();
        requestData.setName(name);
        requestData.setValue(value);
        requestData.setRequestId(requestId);
        
        requestDataFacade.create(requestData);
        return requestData;
    }

    @Override
    public RequestStakeholder createRequestStackeholder(Request requestId, 
            User stakeholder) {
        RequestStakeholderFacade requestStakeholderFacade 
                = new RequestStakeholderFacade();
        RequestStakeholder requestStakeholder = new RequestStakeholder();
        requestStakeholder.setRequestId(requestId);
        requestStakeholder.setUserId(stakeholder);
        
        requestStakeholderFacade.create(requestStakeholder);
        return requestStakeholder;
    }

    @Override
    public Transition createTransition(Process processId, State currentStateId, State nextStateId) {
        TransitionFacade transitionFacade = new TransitionFacade();
        Transition transition = new Transition();
        transition.setProcessId(processId);
        transition.setCurrentStateId(currentStateId);
        transition.setNextStateId(nextStateId);
        
        transitionFacade.create(transition);
        return transition;
    }
    
    
}
