package baseball.game.unit;

import camp.nextstep.edu.missionutils.Console;

public class Pitcher {

	public static Pitcher playerPitcher = new Pitcher();

	private int firstIntentValue;
	private int secondIntentValue;
	private int thirdIntentValue;

	private Pitcher() {
	}

	public void throwBall(Ball ball) {
		ball.changedValue(
				firstIntentValue,
				secondIntentValue,
				thirdIntentValue);
	}

	public void prepareRound() {
		intentThrowingBall();
		checkValidValue();
	}

	private void intentThrowingBall() {
		System.out.print("숫자를 입력해주세요 : ");
		String response = Console.readLine();
		int intent = Integer.parseInt(response);
		firstIntentValue = intent / 100;
		secondIntentValue = intent / 10 % 10;
		thirdIntentValue = intent % 10;
	}

	private void checkValidValue() {
		checkBall(firstIntentValue);
		checkBall(secondIntentValue);
		checkBall(thirdIntentValue);
		if (firstIntentValue == secondIntentValue
				|| firstIntentValue == thirdIntentValue
				|| secondIntentValue == thirdIntentValue) {
			throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
		}
	}

	private void checkBall(int ball) {
		if (ball < 1 || ball > 9) {
			throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
		}
	}
}