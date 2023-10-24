package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class Game {
	private Computer computer;      // 컴퓨터 객첸
	private Player player;          // 사용자 객체

	/**
	 * 생성자 호출 시 게임 시작 메시지 출력 및 컴퓨터, 사용자 객체 생성
	 */
	public Game() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		computer = new Computer();
		player = new Player();
	}

	/**
	 * 게임 결과 확인 메서드: 스트라이크, 볼, 낫싱 확인
	 * @return 게임 종료 여부 반환(스트라이크 3개인 경우 true, 아닌 경우 false)
	 */
	private boolean checkResult() {
		System.out.println("computer: " + computer.getNumberList());
		System.out.println("player: " + player.getNumberList());

		int ball = 0;
		int strike = 0;

		for (int i = 0; i < 3; i++) {
			if (computer.getNumberList().get(i).equals(player.getNumberList().get(i))) {
				strike++;
			} else if (computer.getNumberList().contains(player.getNumberList().get(i))) {
				ball++;
			}
		}

		if (strike == 3) {
			System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}

		if (ball == 0 && strike == 0) {
			System.out.println("낫싱");
		} else {
			if (ball > 0) {
				System.out.print(ball + "볼 ");
			}

			if (strike > 0) {
				System.out.print(strike + "스트라이크");
			}
			System.out.println();
		}
		return false;
	}

	/**
	 * 게임 진행 메서드: 게임 시작 -> 사용자 입력 -> 결과 확인 -> 게임 재시작 여부 확인
	 */
	public void process() {
		while (true) {
			start();

			while (true) {
				player.init();
				if (checkResult()) {
					break;
				}
			}

			if (!isRestart()) {
				break;
			}
		}
	}

	/**
	 * 게임 시작 메서드: 컴퓨터 객체 초기화(랜덤 숫자 재설정)
	 */
	private void start() {
		computer.init();
	}

	/**
	 * 게임 재시작 여부 확인 메서드
	 * @return 재시작 여부
	 */
	private boolean isRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		if (Integer.parseInt(readLine()) != 1) {
			return false;
		}
		return true;
	}

}
