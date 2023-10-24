package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.util.CreateRandomNumberUtil;

public class Computer {
	private List<Integer> computerNumber = new ArrayList<>();
	private CreateRandomNumberUtil randomNumberUtil = new CreateRandomNumberUtil();

	public void setComputerNumber() {
		computerNumber = randomNumberUtil.createRandomNumber();
	}

	public List<Integer> getComputerNumber() {
		return computerNumber;
	}
}
