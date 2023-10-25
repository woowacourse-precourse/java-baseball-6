package baseball;

import camp.nextstep.edu.missionutils.*;

public class BaseBallGameController {
	private final BaseBallGenerator baseBallGenerator;

	// 생성자를 사용하여 Generator 클래스를 주입받아 추상화 된 generate 함수를 사용
	public BaseBallGameController(final BaseBallGenerator baseBallGenerator) {
		this.baseBallGenerator = baseBallGenerator;
	}

	public void play() {
		do {
			System.out.println("숫자 야구 게임을 시작합니다.");
			BaseBallGame baseBallGame = new BaseBallGame(baseBallGenerator.generate());
			while (!baseBallGame.isGameOver()) {
				baseBallGame.start();
			}
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		} // 1외의 다른 숫자는 종료 처리
		while (Console.readLine().equals("1"));
	}
}