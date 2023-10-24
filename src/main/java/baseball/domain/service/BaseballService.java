package baseball.domain.service;

import baseball.global.constant.Output;
import baseball.domain.Client;
import baseball.domain.Computer;
import baseball.global.utils.ConsoleUtil;
import java.util.Objects;

public class BaseballService {

	public void startGame(Computer computer) {
		while (true) {
			ConsoleUtil.commonOutput(Output.INPUT_NUMBER.getComment());
			Client client = new Client();
			calculateBallAndStrikeCount(computer, client);
			ConsoleUtil.ballAndStrikeCountOutput(client.getBall(), client.getStrike());
			if (client.gameEnd()) {
				break;
			}
		}
	}

	private void calculateBallAndStrikeCount(Computer computer, Client client) {
		for (int i = 0; i < computer.getNumbers().size(); i++) {
			increaseCount(computer, client, i);
		}
	}

	private void increaseCount(Computer computer, Client client, Integer i) {
		if (isStrike(computer, client, i)) {
			client.increaseStrikeCount();
		} else if (isBall(computer, client, i)) {
			client.increaseBallCount();
		}
	}

	private boolean isBall(Computer computer, Client client, int i) {
		return computer.getNumbers().contains(client.getNumbers().get(i));
	}

	private boolean isStrike(Computer computer, Client client, int i) {
		return Objects.equals(computer.getNumbers().get(i), client.getNumbers().get(i));
	}
}
