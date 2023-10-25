package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	private Computer computer;
	private Player player;

	public Game(Player player, Computer computer) {
		this.player = player;
		this.computer = computer;
	}

	public void start() {
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println("숫자 야구 게임을 시작합니다.");

		while (true) {

			computer.generateBalls();

			while (true) {
				player.getInput();
				int strike = countStrikeAndBall(computer, player, stringBuffer);

				if (strike == 3) {
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					break;
				}
			}

			if (!askRestart()) {
				break;
			}
		}
	}

	private boolean askRestart() {
		int restart = 0;
		while (true) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			restart = Integer.parseInt(Console.readLine());

			if (restart!=1 && restart!=2) {
				System.out.println("잘못된 입력값입니다. 1이나 2를 입력해주세요.");
			} else {
				break;
			}
		}

		return restart==1 ? true : false;
	}

	private int countStrikeAndBall(Computer computer, Player player, StringBuffer stringBuffer) {
		int strike = 0;
		int ball = 0;

		Ball[] computerBalls = computer.getBalls();
		Ball[] playerBalls = player.getBalls();

		for (int i = 0; i < 3; i++) {
			if (playerBalls[i].equals(computerBalls[i])) {
				strike++;
			} else {
				for (int j = 0; j < 3; j++) {
					if (i != j && playerBalls[i].equals(computerBalls[j])) {
						ball++;
					}
				}
			}
		}

		printStrikeAndBall(stringBuffer, strike, ball);

		return strike;
	}

	private void printStrikeAndBall(StringBuffer stringBuffer, int strike, int ball) {
		if (ball >0 && strike >0) {
			stringBuffer.append(ball);
			stringBuffer.append("볼 ");
			stringBuffer.append(strike);
			stringBuffer.append("스트라이크");
		} else if (ball >0) {
			stringBuffer.append(ball);
			stringBuffer.append("볼");
		} else if (strike >0) {
			stringBuffer.append(strike);
			stringBuffer.append("스트라이크");
		} else {
			stringBuffer.append("낫싱");
		}

		System.out.println(stringBuffer.toString());
		stringBuffer.delete(0, stringBuffer.length());
	}

}
