package command;

/**
 * Static class that would be a spring component used to parse a string and return it's corresponding command
 * @author pa
 *
 */
public final class CommandParser {

	private static final String SPACE = " ";
	private static final String WINNERS = "winners";
	private static final String EMPTY = "";
	private static final String DRAW = "draw";
	private static final String PURCHASE = "purchase";
	private static final String COMMAND_IS_INVALID = "Command is invalid.";
	private static final String COMMAND_IS_EMPTY = "Command is empty.";
	private static final String MISSING_NAME = "Missing name : Please use purchase (name)";

	public static Command parseCommand(String toParse){
		
		//we make sure the command is not null or empty.
		if (toParse == null || toParse.trim().length() == 0){
			return new Command(CommandType.INVALID, COMMAND_IS_EMPTY);
		}

		//the purchase option
		if(toParse.trim().startsWith(PURCHASE)){
			// we remove purchase of the string
			String name = toParse.replace(PURCHASE,EMPTY).trim();
			//if the name is empty we return command invalid message
			if(name.length() == 0){
				return new Command(CommandType.INVALID, MISSING_NAME);
			}else return new Command(CommandType.PURCHASE, name);
		//the draw option
		}else if(toParse.trim().equals(DRAW)){
			return new Command(CommandType.DRAW);
		//the winners option
		}else if(toParse.trim().equals(WINNERS)){
			return new Command(CommandType.WINNERS);
		}
		// we did not recognize the command and return invalid
		return new Command(CommandType.INVALID, COMMAND_IS_INVALID);
	}
}
