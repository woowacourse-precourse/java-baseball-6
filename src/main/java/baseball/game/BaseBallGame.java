package baseball.game;

import baseball.game.setting.Round;
import baseball.game.unit.Catcher;
import baseball.game.unit.Pitcher;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

	public static BaseBallGame newGame() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		return new BaseBallGame();
	}

	private BaseBallGame() {}

	public void play() {
		Catcher.computerCatcher.readyGame();
		do {
			Round round = Round.newRound();
			round.progress(
					Pitcher.playerPitcher,
					Catcher.computerCatcher
			);
		} while (Catcher.computerCatcher.judgeCatherWinRound());
	}

	public boolean askReplay() {
		String response = askReady();
		return isPlayerReady(response);
	}

	private String askReady() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Console.readLine();
	}

	private boolean isPlayerReady(String response) {
		if (response.equals("1")) {
			return true;
		}
		if (response.equals("2")) {
			return false;
		}
		throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
	}
}
