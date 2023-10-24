package baseball.game;

import java.util.Objects;

import baseball.user.Computer;
import baseball.user.Player;
import baseball.game.ui.UI;

public class BaseBallGame {
	private final Computer computer = new Computer();
	private final Player player = new Player();
	private boolean isPlaying = true;

	public void run() {
		UI.START.print();
		while (isPlaying) {
			computer.settingNumbers();
			play();
			if (!isNewGame()) {
				isPlaying = false;
			}
		}
	}

	private boolean isNewGame() {
		UI.NEW_GAME.print();
		String input = UI.input();
		return Objects.equals(input, "1");
	}

	private void play() {
		boolean isPlayerWin = false;

		while (!isPlayerWin) {
			UI.INPUT.print();
			player.pickNumber(UI.input());
			int[] result = computer.inspectNumber(player.getNumber());
			UI.RESULT.print(result);

			if(result[0] == 3) {
				isPlayerWin = true;
			}
		}
		UI.END.print();
	}

}
