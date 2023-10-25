package baseball.domain.service;

import baseball.domain.Client;
import baseball.domain.Computer;
import baseball.global.utils.ConsoleUtil;
import java.util.Objects;

public class BaseballService {

	public void playRound(Computer computer, Client client) {
		calculateBallAndStrikeCount(computer, client);
		ConsoleUtil.ballAndStrikeCountOutput(client.getBallCount(), client.getStrikeCount());
	}

	private void calculateBallAndStrikeCount(Computer computer, Client client) {
		for (int index = 0; index < computer.getNumbers().size(); index++) {
			increaseCount(computer, client, index);
		}
	}

	private void increaseCount(Computer computer, Client client, Integer index) {
		if (isStrike(computer, client, index)) {
			client.increaseStrikeCount();
		} else if (isBall(computer, client, index)) {
			client.increaseBallCount();
		}
	}

	private boolean isBall(Computer computer, Client client, int index) {
		return computer.getNumbers().contains(client.getNumbers().get(index));
	}

	private boolean isStrike(Computer computer, Client client, int index) {
		return Objects.equals(computer.getNumbers().get(index), client.getNumbers().get(index));
	}
}
