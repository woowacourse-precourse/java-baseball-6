package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	private Computer computer;
	private BallExtractor ballExtractor = new BallExtractor();
	private ChooseValidator chooseValidator = new ChooseValidator();

	public void start() {
		welcome();
		play();
	}

	private void welcome() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	private void play() {
		Balls computerBalls = setComputerBalls();
		proceed(computerBalls);
	}

	private Balls setComputerBalls() {
		computer = new Computer();
		return computer.makeNumbers();
	}

	private void proceed(Balls computerBalls) {
		while (true) {
			// 숫자 입력
			System.out.print("숫자를 입력해주세요 : ");
			Balls playerBalls = ballExtractor.extract(Console.readLine());

			// 결과 계산
			Result result = calculate(computerBalls, playerBalls);

			// 결과 출력
			System.out.println(result);

			// 게임 종료
			if (result.getStrike() == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
		}
		exit();
	}

	private Result calculate(Balls computerBalls, Balls playerBalls) {
		Result result = new Result();
		for (int i = 0; i < 3; i++) {
			Integer playerBall = playerBalls.get(i);

			if (!computerBalls.contains(playerBall)) {
				result.increaseNothing();
			} else if (playerBall != computerBalls.get(i)) {
				result.increaseBall();
			} else {
				result.increaseStrike();
			}
		}

		return result;
	}

	private void exit() {
		int answer = question();

		if (answer == 1) {
			play();
		}
	}

	private int question() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		// 숫자 입력
		return chooseValidator.validate(Console.readLine());
	}
}
