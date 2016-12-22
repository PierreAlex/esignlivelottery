package console;
import java.util.Scanner;

import command.Command;
import command.CommandParser;
import command.CommandType;
import lottery.LotteryManager;

/**
 * The console class handling user input. This is the main class
 * @author pa
 *
 */
public class Console 
{
	private static final String THANK_YOU_FOR_USING_E_SIGN_LIVE_LOTERY_SOFTWARE = "Thank you for using ESignLive lotery software.";
	private static final String CORRECT_FORM_MESSAGE = "Please enter purchase (name) or draw or winners";
	private static final String WELCOME_MESSAGE = "Welcome to the lotery app.";
	
    public static void main( String[] args )
    { 
	 LotteryManager loteryManager = new LotteryManager();
	 	Scanner reader = new Scanner(System.in);
    	System.out.println( WELCOME_MESSAGE);
    	Command command = null;
    	// We loop until a successful winners command have been printed. 
    	// This is to make sure the user do not re-roll the result in his favor.
    	while(command == null || !(command.getType() == CommandType.WINNERS && loteryManager.getResult().isSuccessful())){
    		System.out.println( CORRECT_FORM_MESSAGE );
    		command = CommandParser.parseCommand(reader.nextLine());
    		if(command.getType() == CommandType.INVALID){
    			System.out.println(command.getParameter());
    		}else if ( command.getType() == CommandType.PURCHASE){
    			//we add the participant and print the result
    			System.out.println(loteryManager.addParticipant(command.getParameter()));
    		}else if (command.getType() == CommandType.DRAW){
    			loteryManager.draw();
    			System.out.println(loteryManager.getResult().getDrawresultMessage());
    		}else if (command.getType() == CommandType.WINNERS){
    			System.out.println(loteryManager.getResult().getResultMessage());
    		}
    	}
    	reader.close();
    	System.out.println(THANK_YOU_FOR_USING_E_SIGN_LIVE_LOTERY_SOFTWARE);
    }
}
