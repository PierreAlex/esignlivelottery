package lottery;

import java.util.HashMap;

import org.junit.Test;

import junit.framework.TestCase;


public class DrawTest extends TestCase {
	

	
	
	private static final String SUCCESSFUL_DRAW_TO_SEE_RESULT_TYPE_WINNERS = "Successful draw. To see result type winners.";

	@Test
	public void testEmptyDraw(){
		LotteryManager lottery = new LotteryManager();
		lottery.draw();
		assertEquals("You need more participant (Min 3). You currently have 0", lottery.getResult().getDrawresultMessage());
		lottery.addParticipant("1");
		lottery.draw();
		assertEquals("You need more participant (Min 3). You currently have 1", lottery.getResult().getDrawresultMessage());
		lottery.addParticipant("2");
		lottery.draw();
		assertEquals("You need more participant (Min 3). You currently have 2", lottery.getResult().getDrawresultMessage());
		lottery.addParticipant("3");
		lottery.draw();
		assertEquals(SUCCESSFUL_DRAW_TO_SEE_RESULT_TYPE_WINNERS, lottery.getResult().getDrawresultMessage());
	}
	
	@Test
	public void testBigDraw(){
		LotteryManager lottery = new LotteryManager();
		HashMap<String,String> test = new HashMap<String,String>();
		for(int i = 1 ; i < 61 ; i ++){
			assertEquals(lottery.addParticipant("Participant " + i), "Participant added. Participant number : " + i);
			test.put("Participant " + i,"1");
		}
		lottery.draw();
		assertEquals("First prize pool is incorect",375.0, lottery.getResult().getFirstPrize() );
		assertEquals("Second prize pool is incorect",75.0, lottery.getResult().getSecondPrize() );
		assertEquals("Third prize pool is incorect",50.0, lottery.getResult().getThirdPrize() );
		assertTrue(lottery.getResult().getFirstWinner().startsWith("Participant "));
		assertTrue(lottery.getResult().getSecondWinner().startsWith("Participant "));
		assertTrue(lottery.getResult().getThirdWinner().startsWith("Participant "));
		assertTrue(lottery.getResult().isSuccessful());
		test.remove(lottery.getResult().getFirstWinner());
		test.remove(lottery.getResult().getSecondWinner());
		test.remove(lottery.getResult().getThirdWinner());
		assertEquals("Not all participant have been selected",test.size(), 57);
		assertEquals("Draw message unexpected",lottery.getResult().getDrawresultMessage(), SUCCESSFUL_DRAW_TO_SEE_RESULT_TYPE_WINNERS );
	}
	
	
}
