package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.BaseballNumber;
import baseball.util.generator.NumberGenerator;

public class BaseballCreateService {
	
	private static final int LENGTH = 3;
	
	public BaseballNumber createBaseballNumber() {
		List<Integer> computer = new ArrayList<>();
		NumberGenerator generator = new NumberGenerator();

		while (computer.size() < LENGTH) {
			int randomNumber = generator.generate();
			
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		return new BaseballNumber(computer);
	}
}
