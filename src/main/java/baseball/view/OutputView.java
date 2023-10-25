package baseball.view;

public class OutputView {
	private final String START_GAME = "숫자 야구 게임을 시작합니다.";
	private final String CORRECT_NUMBER_AND_FINISH_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	
	public void startGameMessage() {
		System.out.println(START_GAME);
	}
	
	public void endGameMessage() {
		System.out.println(CORRECT_NUMBER_AND_FINISH_GAME);
	}
	
	public void hintMessage(String hintMessage) {
		System.out.println(hintMessage);
	}
}
