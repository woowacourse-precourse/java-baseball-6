package baseball;

/* 게임을 반복 진행 */
public class BaseballGame {
	private final BaseballView baseballView; // 입출력 스크립트를 작성
	private final BaseballComputer baseballComputer; // 게임에 필요한 숫자를 생성
	private final BaseballUmpire baseballUmpire; // 유저가 입력한 숫자를 판정

	public BaseballGame(
		BaseballView baseballView, BaseballComputer baseballComputer, BaseballUmpire baseballUmpire
	) {
		this.baseballView = baseballView;
		this.baseballComputer = baseballComputer;
		this.baseballUmpire = baseballUmpire;
	}

	public void startBaseballGame() {
		do {
			String computerNumber = baseballComputer.createComputerNumbers();
			System.out.println("테스트 용 컴퓨터 숫자 출력:: " + computerNumber);
			do {
				processBaseballGame(computerNumber); // 게임 진행
			} while (!isThreeStrike());
		} while (!isGameEnd());
	}

	private boolean isGameEnd() {
		// 게임 종료 여부, 1 = 재시작, 2 = 종료
		return baseballView.inputSelectRestartOrEnd() == 2;
	}

	private boolean isThreeStrike() {
		// 3 strike인지 확인
		return baseballUmpire.getStrike() >= 3;
	}

	private void processBaseballGame(String computerNumber) {
		// 유저가 숫자 입력
		baseballView.printUserNumber();
		String userNumber = baseballView.inputUserNumber();

		// 숫자 판정
		int[] umpireResults = baseballUmpire.umpire(computerNumber, userNumber);
		int ball = umpireResults[0];
		int strike = umpireResults[1];

		// 판정 결과
		if (isUmpireResultsNothing(ball, strike)) {
			baseballView.printResultNothing();
		} else {
			if (ball != 0) {
				baseballView.printResultBall(ball);
			}
			if (strike != 0) {
				baseballView.printResultStrike(strike);
			}
		}

	}

	private boolean isUmpireResultsNothing(int ball, int strike) {
		return ball == 0 && strike == 0;
	}
}