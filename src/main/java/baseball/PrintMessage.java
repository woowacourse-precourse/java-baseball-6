package baseball;

public class PrintMessage {
	public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
	
	public static final String INPUT_NUM_MESSAGE = "숫자를 입력해주세요 : ";
	
	public static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	
	public static final String NOTHING_MESSAGE = "낫싱";
	
	public static final String BALL_MESSAGE = "볼";
	
	public static final String STRIKE_MESSAGE = "스트라이크";
	;
	public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	
	 public void StartMessage() {
		 System.out.println(START_GAME_MESSAGE);
	 }
	 
	 public void InputMessage() {
		 System.out.print(INPUT_NUM_MESSAGE);
	 }
	 
	 public void CorrectMessage() {
		 System.out.println(CORRECT_MESSAGE);
	 }
	 
	 public void ResultMessage(int ball, int strike) {
			StringBuilder resultMessage = new StringBuilder();
			if(ball == 0 && strike == 0)
				resultMessage.append(NOTHING_MESSAGE);
			
			if(ball != 0)
				resultMessage.append(ball).append(BALL_MESSAGE).append(" ");
			
			if(strike != 0)
				resultMessage.append(strike).append(STRIKE_MESSAGE);
			
			System.out.println(resultMessage.toString().trim());
	 }
	 
	 public void RestartMessage() {
		 System.out.println(RESTART_MESSAGE);
	 }
}
