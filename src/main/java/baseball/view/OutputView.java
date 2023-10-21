package baseball.view;

import baseball.domain.HintResult;

public class OutputView {

	private OutputView() {
	}

	public static void startMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public static void printHint(HintResult hintResult) {
		System.out.println(hintResult);
	}
}
