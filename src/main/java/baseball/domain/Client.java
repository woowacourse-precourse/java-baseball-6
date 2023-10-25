package baseball.domain;

import baseball.domain.service.ClientService;
import baseball.global.constant.CommonNumberType;
import java.util.List;

public class Client {

	private final ClientNumbers numbers;
	private int ballCount;
	private int strikeCount;

	public Client() {
		numbers = new ClientNumbers(new ClientService().getCommonInput());
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void increaseBallCount() {
		this.ballCount++;
	}

	public void increaseStrikeCount() {
		this.strikeCount++;
	}

	public List<Integer> getNumbers() {
		return numbers.getNumbers();
	}

	public boolean gameEnd() {
		return strikeCount == CommonNumberType.MAXIMUM_COUNT.getValue();
	}
}
