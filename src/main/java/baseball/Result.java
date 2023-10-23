package baseball;

public record Result(
		int ball,
		int strike,
		boolean isAnswer
) {
	void printResult() {
		if (ball() > 0) {
			System.out.printf("%d볼 ", ball());
		}
		if (strike() > 0) {
			System.out.printf("%d스트라이크", strike());
		}
		if (ball() + strike() == 0) {
			System.out.print("낫싱");
		}
		if (isAnswer()) {
			System.out.printf("\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Constants.NUMBER_LENGTH);
		}

		System.out.println();
	}
}