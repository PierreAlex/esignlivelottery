package command;

import org.junit.Test;

import junit.framework.TestCase;


public class CommandParserTest extends TestCase {
	
	private static final String MISSING_NAME_PLEASE_USE_PURCHASE_NAME = "Missing name : Please use purchase (name)";
	private static final String COMMAND_IS_EMPTY= "Command is empty.";
	private static final String COMMAND_IS_INVALID = "Command is invalid.";

	@Test
	public void testEmpty(){
		Command command = CommandParser.parseCommand("");
		assertEquals(command.getType(), CommandType.INVALID);
		assertEquals(command.getParameter(),COMMAND_IS_EMPTY);
		
		command = CommandParser.parseCommand(null);
		assertEquals(command.getType(), CommandType.INVALID);
		assertEquals(command.getParameter(),COMMAND_IS_EMPTY);
		
		command = CommandParser.parseCommand("     ");
		assertEquals(command.getType(), CommandType.INVALID);
		assertEquals(command.getParameter(),COMMAND_IS_EMPTY);
	}
	
	@Test
	public void testInvalid(){
		Command command = CommandParser.parseCommand(" purchase");
		assertEquals(command.getType(), CommandType.INVALID);
		assertEquals(command.getParameter(),MISSING_NAME_PLEASE_USE_PURCHASE_NAME);
		
		command = CommandParser.parseCommand("aasd  asd asd");
		assertEquals(command.getType(), CommandType.INVALID);
		assertEquals(command.getParameter(),COMMAND_IS_INVALID);
		
		command = CommandParser.parseCommand("winnersasd  asd asd");
		assertEquals(command.getType(), CommandType.INVALID);
		assertEquals(command.getParameter(),COMMAND_IS_INVALID);
	}
	
	@Test
	public void testMissingName(){
		Command command = CommandParser.parseCommand("purchase        ");
		assertEquals(command.getType(), CommandType.INVALID);
		assertEquals(command.getParameter(),MISSING_NAME_PLEASE_USE_PURCHASE_NAME);
		
		command = CommandParser.parseCommand("purchase");
		assertEquals(command.getType(),CommandType.INVALID);
		assertEquals(command.getParameter(),MISSING_NAME_PLEASE_USE_PURCHASE_NAME);
		
	}
	
	@Test
	public void testPurchase(){
		Command command = CommandParser.parseCommand("purchase DAVID DELACROIX");
		assertEquals(command.getType(),CommandType.PURCHASE);
		assertEquals(command.getParameter(), "DAVID DELACROIX");
		
		command = CommandParser.parseCommand("purchase  DAVID DELACROIX   ");
		assertEquals(command.getType(), CommandType.PURCHASE);
		assertEquals(command.getParameter(),"DAVID DELACROIX");
		
		command = CommandParser.parseCommand(" purchase  DAVID DELACROIX   ");
		assertEquals(command.getType(), CommandType.PURCHASE);
		assertEquals(command.getParameter(), "DAVID DELACROIX");
		
	}
	
	@Test
	public void testDraw(){
		Command command = CommandParser.parseCommand("draw ");
		assertEquals(command.getType(), CommandType.DRAW);
		
		command = CommandParser.parseCommand("draw");
		assertEquals(command.getType(), CommandType.DRAW);
		
		command = CommandParser.parseCommand(" draw ");
		assertEquals(command.getType(), CommandType.DRAW);
		
	}
	
	@Test
	public void testWinners(){
		Command command = CommandParser.parseCommand("winners ");
		assertEquals(command.getType(), CommandType.WINNERS);
		
		command = CommandParser.parseCommand("winners");
		assertEquals(command.getType(), CommandType.WINNERS);
		
		command = CommandParser.parseCommand(" winners");
		assertEquals(command.getType(), CommandType.WINNERS);
		
	}
}
