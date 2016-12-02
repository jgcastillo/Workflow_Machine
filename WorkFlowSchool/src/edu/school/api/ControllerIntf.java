package edu.school.api;

import edu.school.entities.Process;
import edu.school.entities.ProcessAdmin;
import edu.school.entities.Request;
import edu.school.entities.RequestData;
import edu.school.entities.RequestStakeholder;
import edu.school.entities.State;
import edu.school.entities.Transition;
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
}
