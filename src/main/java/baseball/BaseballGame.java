package baseball;

/* 게임을 반복 진행 */
public class BaseballGame {
	private final BaseballView baseballView; // 입출력 스크립트를 작성
	private final BaseballComputer baseballComputer; // 게임에 필요한 숫자를 생성
	private final BaseballUmpire baseballUmpire; // 유저가 입력한 숫자를 판정

	private boolean isCorrect; // 게임의 정답을 맞췄는지 여부
	private boolean isGameEnd; // 게임이 완전히 종료되는지 여부

	public BaseballGame(
		BaseballView baseballView, BaseballComputer baseballComputer, BaseballUmpire baseballUmpire
	) {
		this.baseballView = baseballView;
		this.baseballComputer = baseballComputer;
		this.baseballUmpire = baseballUmpire;

		isCorrect = false;
		isGameEnd = false;
	}

	public void startBaseballGame() {
		do {
			// 컴퓨터 숫자 생성
			String computerNumber = createComputerNumbers();
			// 정답 여부 초기화
			isCorrect = false; 
			do {
				// 게임 진행
				processBaseballGame(computerNumber);
			} while (!isCorrect);
		} while (!isGameEnd);
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

		// 게임 종료 메세지
		if (strike == 3) {
			baseballView.printFinishGame();
			isCorrect = true;

			// 유저가 게임 재시작, 종료 선택
			baseballView.printSelectRestartOrEnd();
			int selectNumber = baseballView.inputSelectRestartOrEnd();
			if (selectNumber == 2) {
				isGameEnd = true;
			}
		}
	}

	private String createComputerNumbers() {
		// 숫자 생성
		String computerNumber = baseballComputer.createComputerNumbers();
		System.out.println("테스트 용 컴퓨터 숫자 출력:: " + computerNumber);
		return computerNumber;
	}

	private boolean isUmpireResultsNothing(int ball, int strike) {
		return ball == 0 && strike == 0;
	}
}