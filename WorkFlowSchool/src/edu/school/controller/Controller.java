package edu.school.controller;

import edu.school.api.ControllerIntf;
import edu.school.entities.Action;
import edu.school.entities.ActionTarget;
import edu.school.entities.Activity;
import edu.school.entities.ActivityTarget;
import edu.school.entities.ActivityType;
import edu.school.entities.Group;
import edu.school.entities.GroupMember;
import edu.school.entities.Process;
import edu.school.entities.ProcessAdmin;
import edu.school.entities.Request;
import edu.school.entities.RequestAction;
import edu.school.entities.RequestData;
import edu.school.entities.RequestStakeholder;
import edu.school.entities.State;
import edu.school.entities.Target;
import edu.school.entities.Transition;
import edu.school.entities.TransitionAction;
import edu.school.entities.User;
import edu.school.persistence.ActionFacade;
import edu.school.persistence.ActionTargetFacade;
import edu.school.persistence.ActivityFacade;
import edu.school.persistence.ActivityTargetFacade;
import edu.school.persistence.ActivityTypeFacade;
import edu.school.persistence.GroupFacade;
import edu.school.persistence.GroupMemberFacade;
import edu.school.persistence.ProcessAdminFacade;
import edu.school.persistence.ProcessFacade;
import edu.school.persistence.RequestActionFacade;
import edu.school.persistence.RequestDataFacade;
import edu.school.persistence.RequestFacade;
import edu.school.persistence.RequestStakeholderFacade;
import edu.school.persistence.StateFacade;
import edu.school.persistence.TargetFacade;
import edu.school.persistence.TransitionActionFacade;
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

    @Override
    public Action createAction(String actionType, Process processId, String name, String description) {
        ActionFacade actionFacade = new ActionFacade();
        Action action = new Action();
        
        action.setActionType(actionType);
        action.setProcessId(processId);
        action.setName(name);
        action.setDescription(description);
        
        actionFacade.create(action);
        return action;
    }

    @Override
    public TransitionAction createTransitionAction(Transition transitionId, Action actionId) {
        TransitionActionFacade transitionActionFacade = new TransitionActionFacade();
        TransitionAction transitionAction = new TransitionAction();
        
        transitionAction.setTransitionId(transitionId);
        transitionAction.setActionId(actionId);
        
        transitionActionFacade.create(transitionAction);
        return transitionAction;
    }
    
    @Override
    public ActivityType createActivityType(String name){
        ActivityTypeFacade activityTypeFacade = new ActivityTypeFacade();
        ActivityType activityType = new ActivityType();
        
        activityType.setName(name);
        
        activityTypeFacade.create(activityType);
        return activityType;
    }
    
    @Override
    public Activity createActivity(ActivityType activityTypeId, Process processId,
            String name, String description){
        ActivityFacade activityFacade = new ActivityFacade();
        Activity activity = new Activity();
        
        activity.setActivityTypeId(activityTypeId);
        activity.setProcessId(processId);
        activity.setName(name);
        activity.setDescription(description);
        
        activityFacade.create(activity);
        return activity;
    }
    
    @Override
    public Group createGroup(Process processId, String name){
        GroupFacade groupFacade = new GroupFacade();
        Group group = new Group();
        
        group.setProcessId(processId);
        group.setName(name);
        
        groupFacade.create(group);
        return group;
    }
    
    @Override
    public GroupMember createGroupMember(Group groupId, User userId){
        GroupMemberFacade groupMemberFacade = new GroupMemberFacade();
        GroupMember groupMember = new GroupMember();
        
        groupMember.setGroupId(groupId);
        groupMember.setUserId(userId);
        
        groupMemberFacade.create(groupMember);
        return groupMember;
    }
    
    @Override
    public Target createTarget(String name, String description) {
        TargetFacade targetFacade = new TargetFacade();
        Target target = new Target();

        target.setName(name);
        target.setDescription(description);

        targetFacade.create(target);
        return target;
    }
    
    @Override
    public ActionTarget createActionTarget(Action actionId, Target targetId,
            Group groupId) {
        ActionTargetFacade actionTargetFacade = new ActionTargetFacade();
        ActionTarget actionTarget = new ActionTarget();

        actionTarget.setActionId(actionId);
        actionTarget.setTargetId(targetId);
        actionTarget.setGroupId(groupId);
        
        actionTargetFacade.create(actionTarget);
        return actionTarget;
    }
    
    @Override
    public ActivityTarget createActionTarget(Activity activityId, Target targetId,
            Group groupId){
        ActivityTargetFacade activityTargetFacade = new ActivityTargetFacade();
        ActivityTarget activityTarget = new ActivityTarget();

        activityTarget.setActivityId(activityId);
        activityTarget.setTargetId(targetId);
        activityTarget.setGroupId(groupId);

        activityTargetFacade.create(activityTarget);
        return activityTarget;
    }
    
    @Override
    public RequestAction createRequestAction(Request requestId, Action actionId,
            Transition transitionId, int isActive, int isComplete){
        RequestActionFacade requestActionFacade = new RequestActionFacade();
        RequestAction requestAction = new RequestAction();
        
        requestAction.setRequestId(requestId);
        requestAction.setActionId(actionId);
        requestAction.setTransitionId(transitionId);
        requestAction.setIsActive(isActive);
        requestAction.setIsComplete(isComplete);
        
        requestActionFacade.create(requestAction);
        return requestAction;
    }
}
