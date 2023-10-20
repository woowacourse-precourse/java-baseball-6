package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.BaseballNumber;
import baseball.util.generator.NumberGenerator;

public class BaseballCreateService {

	public BaseballNumber createBaseballNumber() {
		List<Integer> computer = new ArrayList<>();
		NumberGenerator generator = new NumberGenerator();

		while (computer.size() < 3) {
			int randomNumber = generator.generate();
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		return new BaseballNumber(computer);
	}
}
