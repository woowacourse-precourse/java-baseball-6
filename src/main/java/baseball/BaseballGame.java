package baseball;

/* 게임을 반복 진행 */
public class BaseballGame {
	private final BaseballView baseballView = new BaseballView();
	private boolean isGameEnd = false; // 게임이 완전히 종료되는지 여부

	public void startBaseballGame() {
		do {
			processBaseballGame();
		} while (!isGameEnd);
	}

	private void processBaseballGame() {
		// 게임 출력
		baseballView.printGameStart();

		// 유저가 숫자 입력
		baseballView.printUserNumber();
		String userNumber = baseballView.inputUserNumber();

		// 판정
		baseballView.printResultBall(1);
		baseballView.printResultStrike(1);
		baseballView.printResultNothing();

		// 게임 종료
		baseballView.printFinishGame();

		// 유저가 게임 재시작, 종료 선택
		baseballView.printSelectRestartOrEnd();
		int selectNumber = baseballView.inputSelectRestartOrEnd();
	}
}