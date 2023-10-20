package baseball.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.domain.BaseballNumber;

public class BaseballCheckAnswerService {

	public int getBallCount(BaseballNumber answer, int number) {
		List<Integer> dividedDigit = divideIntoDigit(number);
		int ballCount = 0;

		for (int i = 0; i < answer.size(); i++) {
			int dividedNumber = dividedDigit.get(i);
			if (answer.contains(dividedNumber) && answer.get(i) != dividedNumber) {
				ballCount++;
			}
		}

		return ballCount;
	}

	public int getStrikeCount(BaseballNumber answer, int number) {
		List<Integer> dividedDigit = divideIntoDigit(number);
		int StrikeCount = 0;

		for (int i = 0; i < answer.size(); i++) {
			int dividedNumber = dividedDigit.get(i);
			if (answer.get(i) == dividedNumber) {
				StrikeCount++;
			}
		}

		return StrikeCount;
	}

	public static List<Integer> divideIntoDigit(int number) {
		List<Integer> result = new ArrayList<>();

		while (number > 0) {
			result.add(number % 10);
			number /= 10;
		}

		Collections.reverse(result);

		return result;
	}
}
