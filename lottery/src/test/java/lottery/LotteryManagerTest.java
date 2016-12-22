package lottery;

import org.junit.Test;

import junit.framework.TestCase;


public class LotteryManagerTest extends TestCase {
	
	private static final String COMMAND_IS_COMMAND = "Command is command.";
	private static final String COMMAND_IS_INVALID = "Command is invalid.";

	@Test
	public void testWinnersWithoutDraw(){
		LotteryManager lottery = new LotteryManager();
		assertEquals("There have not been a successful draw yet", lottery.getResult().getResultMessage().trim());
		lottery.draw();
		assertEquals("There have not been a successful draw yet", lottery.getResult().getResultMessage().trim());
		lottery.addParticipant("1");
		assertEquals("There have not been a successful draw yet", lottery.getResult().getResultMessage().trim());
		lottery.draw();
		assertEquals("There have not been a successful draw yet", lottery.getResult().getResultMessage().trim());
		assertEquals("You need more participant (Min 3). You currently have 1", lottery.getResult().getDrawresultMessage().trim());

	}
	
	@Test
	public void testWinnersOutput(){
		LotteryManager lottery = new LotteryManager();
		lottery.addParticipant("1");
		lottery.addParticipant("1");
		lottery.addParticipant("1");
		lottery.draw();
		assertEquals("1st ball      2nd ball      3rd ball\n1: 86.25$     1: 17.25$     1: 11.5$", lottery.getResult().getResultMessage().trim());
	}
	
	@Test
	public void testAddParticipant(){
		LotteryManager lottery = new LotteryManager();
		assertEquals("Participant added. Participant number : 1",lottery.addParticipant("1"));
		assertEquals("Participant added. Participant number : 2",lottery.addParticipant("3"));
	}
	
}

