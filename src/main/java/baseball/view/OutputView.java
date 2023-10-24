package baseball.view;

import static baseball.domain.Number.NUMBER_SIZE;

public class OutputView {
	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String END_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void printResult(String result) {
		System.out.println(result);
	}

	public static void printStart() {
		System.out.println(START_MESSAGE);
	}

	public static void printEnd() {
		System.out.println(String.format(END_MESSAGE, NUMBER_SIZE));
	}

}
