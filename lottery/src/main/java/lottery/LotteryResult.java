package lottery;

/**
 * Simple data object. Also construct the result string according to it's current value
 * @author pa
 *
 */
public class LotteryResult {
	
	private static final String LINEBREAK = "\n";
	private static final String SPACE = " ";
	private static final String FIRST_BALL = "1st ball";
	private static final String SECOND_BALL = "2nd ball";
	private static final String THIRD_BALL = "3rd ball";
	private static final String DOLLAR_SIGNANDSPACE = "$     ";
	private static final String COLON = ": ";
	private static final String THERE_HAVE_NOT_BEEN_A_DRAW_YET = "There have not been a successful draw yet";
	private boolean successfuldraw = false;
	private String firstWinner;
	private String secondWinner;
	private String thirdWinner;
	private double firstPrize;
	private double secondPrize;
	private double thirdPrize;
	
	private String drawresultMessage = THERE_HAVE_NOT_BEEN_A_DRAW_YET;
	
	public LotteryResult() {
	}

	public boolean isSuccessful() {
		return successfuldraw;
	}
	
	public void setSuccessfull(boolean successfull) {
		this.successfuldraw = successfull;
	}
	
	public String getFirstWinner() {
		return firstWinner;
	}
	
	public void setFirstWinner(String firstWinner) {
		this.firstWinner = firstWinner;
	}
	
	public String getSecondWinner() {
		return secondWinner;
	}
	
	public void setSecondWinner(String secondWinner) {
		this.secondWinner = secondWinner;
	}
	
	public String getThirdWinner() {
		return thirdWinner;
	}
	
	public void setThirdWinner(String thirdWinner) {
		this.thirdWinner = thirdWinner;
	}
	
	public double getFirstPrize() {
		return firstPrize;
	}
	
	public void setFirstPrize(double firstPrize) {
		this.firstPrize = firstPrize;
	}
	
	public double getSecondPrize() {
		return secondPrize;
	}
	
	public void setSecondPrize(double secondPrize) {
		this.secondPrize = secondPrize;
	}
	
	public double getThirdPrize() {
		return thirdPrize;
	}
	
	public void setThirdPrize(double thirdPrize) {
		this.thirdPrize = thirdPrize;
	}

	public String getDrawresultMessage() {
		return drawresultMessage;
	}

	public void setDrawresultMessage(String drawresultMessage) {
		this.drawresultMessage = drawresultMessage;
	}
	
	/**
	 * Construct the result string according to it's current state
	 * @return
	 */
	public String getResultMessage() {
		//if there have been no successful draw we display default error message
		if(!successfuldraw){
			return THERE_HAVE_NOT_BEEN_A_DRAW_YET;
		}
		StringBuilder result = new StringBuilder();
		//we append the string for each winner and round to 2 decimal
		String first = getFirstWinner() + COLON + Math.round(getFirstPrize()*100) / 100.0 + DOLLAR_SIGNANDSPACE;
		String second = getSecondWinner() + COLON +  Math.round(getSecondPrize()*100) / 100.0 + DOLLAR_SIGNANDSPACE;
		String third = getThirdWinner() + COLON +  Math.round(getThirdPrize()*100) / 100.0 + DOLLAR_SIGNANDSPACE;
		//we append the first line and add space so the output is well align with the second line
		result.append(FIRST_BALL);
		for (int i = 0; i < first.length() - FIRST_BALL.length() ; i++){
			result.append(SPACE);
		}
		result.append(SECOND_BALL);
		for (int i = 0; i < second.length() - SECOND_BALL.length(); i++){
			result.append(SPACE);
		} 
		result.append(THIRD_BALL);
		result.append(LINEBREAK);
		//we append the second line
		result.append(first);
		result.append(second );
		result.append(third );
		return result.toString();
	}
}
