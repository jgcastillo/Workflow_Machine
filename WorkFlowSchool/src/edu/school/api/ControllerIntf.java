package edu.school.api;

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
import java.util.Date;

public interface ControllerIntf {
    
    /**
     * Crea un objeto de tipo User y lo hace persistente en la BD
     * @param firstName
     * @param lastName
     * @param birthdayDate
     * @return 
     */
    public User createUser(String firstName, String lastName, Date birthdayDate);
    
    /**
     * Crea un objeto de tipo Process y lo hace persistente en la BD
     * @param name
     * @return 
     */
    public Process createProcess(String name);
    
    /**
     * Crea un objeto de tipo Request y lo hace persistente en la BD
     * @param title
     * @param dateRequested
     * @param process
     * @param currentState
     * @param userId
     * @return 
     */
    public Request createRequest(String title, Date dateRequested,
            Process process, State currentState, User userId);
    
    
    /**
     * Asigna un Process a un User, creando un objeto ProcessAdmin
     * y lo hace persistente en la BD
     * @param process
     * @param user
     * @return 
     */
    public ProcessAdmin assignAdmin(Process process, User user);
    
    /**
     * Crea un objeto de tipo State y lo hace persistente en la BD
     * @param stateType
     * @param process
     * @param name
     * @param description
     * @return 
     */
    public State createState(String stateType, Process process,
            String name, String description);
    
    /**
     * Crea el objeto con la data correspondiente a un requerimiento
     * @param requestId
     * @param name
     * @param value
     * @return 
     */
    public RequestData createRequestData(String name, String value, 
            Request requestId);
    
    /**
     * Asigna un interesado (stakeholder) en conocer sobre el requerimiento
     * @param requestId
     * @param stakeholder
     * @return 
     */
    public RequestStakeholder createRequestStackeholder(Request requestId, 
            User stakeholder);
    
    /**
     * Crea un objeto Transition cuando un Process cambia de un State (actual)
     * a un nuevo State (siguiente) 
     * @param processId
     * @param currentStateId
     * @param nextStateId
     * @return 
     */
    public Transition createTransition(Process processId, State currentStateId,
            State nextStateId);
    
    /**
     * Crea un objeto Action y lo hace persistente en la base de datos.
     * @param actionType
     * @param processId
     * @param name
     * @param description
     * @return 
     */
    public Action createAction(String actionType, Process processId, String name,
            String description);
    
    /**
     * Crea un objeto TransitionAction y lo hace persistente en la base de datos
     * @param transitionId
     * @param actionId
     * @return 
     */
    public TransitionAction createTransitionAction(Transition transitionId,
            Action actionId);
    
    /**
     * Crea un objeto ActivityType y lo hace persistente en la base de datos
     * @param name
     * @return 
     */
    public ActivityType createActivityType(String name);
    
    /**
     * Crea un objeto Activity y lo hace persistente en la base de datos
     * @param activityTypeId
     * @param processId
     * @param name
     * @param description
     * @return 
     */
    public Activity createActivity(ActivityType activityTypeId, Process processId,
            String name, String description);
    
    /**
     * Crea un objeto Group y lo hace persistente en la base de datos
     * @param processId
     * @param name
     * @return 
     */
    public Group createGroup(Process processId, String name);
    
    /**
     * Crea un objeto GroupMember y lo hace persistente en la base de datos
     * @param groupId
     * @param userId
     * @return 
     */
    public GroupMember createGroupMember(Group groupId, User userId);
    
    /**
     * Crea un objeto Target y lo hace persistente en la base de datos
     * @param name
     * @param description
     * @return 
     */
    public Target createTarget(String name, String description);
    
    /**
     * Crea un objeto ActionTarget y lo hace persistente en la base de datos
     * @param actionId
     * @param targetId
     * @param groupId
     * @return 
     */
    public ActionTarget createActionTarget(Action actionId, Target targetId,
            Group groupId); 
    
    /**
     * Crea un objeto ActivityTarget y lo hace persistente en la base de datos
     *
     * @param actionId
     * @param targetId
     * @param groupId
     * @return
     */
    public ActivityTarget createActionTarget(Activity activityId, Target targetId,
            Group groupId);
    
    /**
     * Crea un objeto RequestAction y lo hace persistente en la base de datos
     * 
     * @param requestId
     * @param actionId
     * @param transitionId
     * @param isActive
     * @param isComplete
     * @return 
     */
    public RequestAction createRequestAction(Request requestId, Action actionId,
            Transition transitionId, int isActive, int isComplete);
}
