package baseball.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import baseball.service.constant.NumberConstant;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	public String getRandomNumber() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < NumberConstant.PICK_COUNT.getValue()) {
			int randomNumber = Randoms.pickNumberInRange(NumberConstant.MIN_NUMBER.getValue(),
				NumberConstant.MAX_NUMBER.getValue());
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
			}
		}
		return numbers.stream().map(String::valueOf).collect(Collectors.joining());
	}
}
