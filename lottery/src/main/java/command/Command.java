package command;

/**
 * Represent a command entered by the user
 * @author pa
 *
 */

public class Command {

	/**
	 * General constructor. If you wish to make a purchase command use the constructor with a name String
	 * @param type
	 */
	public Command (CommandType type){
		this.type = type;
	}

	/**
	 * Constructor to use for purchase command. It also have a name parameter
	 * @param type
	 * @param name
	 */
	public Command ( CommandType type, String parameter){
		this.type = type;
		this.parameter = parameter;
	}
	//the command type
	private CommandType type;
	// used in the purchase command to identify the participant
	private String parameter;
	
	public CommandType getType() {
		return type;
	}
	
	public void setType(CommandType type) {
		this.type = type;
	}
	
	public String getParameter() {
		return parameter;
	}
	
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
 