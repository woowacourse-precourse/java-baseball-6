package baseball;

import java.util.List;

// 스트라이크와 볼의 개수를 판정하는 기능
public class CountDecision {

	static int countBall(List<Integer> computerNumber, List<Integer> userNumber) {

		int ballNumber = 0;

		for (int eachUserNumber : userNumber) {
			if (computerNumber.contains(eachUserNumber)) {
				ballNumber++;
			}
		}

		return ballNumber;
	}

	static int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {

		int strikeNumber = 0;

		for (int i = 0; i < userNumber.size(); i++) {
			if (computerNumber.get(i).equals(userNumber.get(i))) {
				strikeNumber++;
			}
		}

		return strikeNumber;
	}

}
