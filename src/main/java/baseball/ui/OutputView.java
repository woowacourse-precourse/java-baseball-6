package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class OutputView {

	public void printGameStart() {
		println("숫자 야구 게임을 시작합니다.");
	}

	public void printInputNumber() {
		print("숫자를 입력해주세요 : ");
	}

	public void printGameEnd() {
		println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void printGameRestart() {
		println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	private void println(String message) {
		System.out.println(message);
	}

	private void print(String message) {
		System.out.print(message);
	}
}
