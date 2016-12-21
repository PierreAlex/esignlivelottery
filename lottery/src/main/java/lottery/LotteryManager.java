package lottery;

import java.util.ArrayList;
import java.util.Random;

public class LotteryManager {
	
	private static final String PARTICIPANT_ADDED_PARTICIPANT_NUMBER = "Participant added. Participant number : ";
	private static final String SUCCESSFUL_DRAW_TO_SEE_RESULT_TYPE_WINNERS = "Successful draw. To see result type winners.";
	private static final String MORE_PARTICIPANT = "You need more participant (Min 3). You currently have ";
	private static final int COSTPERPARTICIPATION = 10;
	private ArrayList<String> participationList = new ArrayList<String>();
	//initialize with an empty LotteryResult
	private LotteryResult result = new LotteryResult();
	
	/**
	 * Add a participant. And return status message
	 * @param participant
	 * @return
	 */
	public String addParticipant(String participant) {
		participationList.add(participant);
		return PARTICIPANT_ADDED_PARTICIPANT_NUMBER + participationList.size();
	}
	
	public LotteryResult getResult() {
		return result;
	}
	
	/**
	 * Do a lottery draw. To get the result use getResult
	 */
	public void draw(){
		result = new LotteryResult();
		if(participationList.size() < 3){
			result.setSuccessfull(false);
			result.setDrawresultMessage(MORE_PARTICIPANT + participationList.size());
			return;
		}
		Random random = new Random();
		int totalPot = participationList.size() * COSTPERPARTICIPATION / 2;
		result.setFirstPrize(totalPot * 0.75);
		result.setSecondPrize(totalPot * 0.15);
		result.setThirdPrize(totalPot * 0.10);
		
		
		int first = random.nextInt(participationList.size());
		int second = random.nextInt(participationList.size());
		while (second == first){
			second = random.nextInt(participationList.size());
		}
		int third = random.nextInt(participationList.size());
		while (third == first || third == second){
			third = random.nextInt(participationList.size());
		}
		result.setFirstWinner(participationList.get(first));
		result.setSecondWinner(participationList.get(second));
		result.setThirdWinner(participationList.get(third));
		
		result.setDrawresultMessage(SUCCESSFUL_DRAW_TO_SEE_RESULT_TYPE_WINNERS);
		result.setSuccessfull(true);
	}
	
}
