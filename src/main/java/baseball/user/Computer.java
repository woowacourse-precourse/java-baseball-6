package baseball.user;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<String> computerNumbers;

	public void settingNumbers() {
		ArrayList<String> randomNumbers = new ArrayList<>();

		while (randomNumbers.size() < 3) {
			String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
			if (!randomNumbers.contains(randomNumber)) {
				randomNumbers.add(randomNumber);
			}
		}
		this.computerNumbers = randomNumbers;
	}

	public int[] inspectNumber(String input) {
		int strikeCount = 0;
		int ballCount = 0;

		String[] split = input.split("");
		for (int i = 0; i < split.length; i++) {
			String target = split[i];
			if (target.equals(computerNumbers.get(i))) {
				strikeCount++;
			} else if (computerNumbers.contains(target)) {
				ballCount++;
			}
		}

		return new int[] {strikeCount, ballCount};
	}

	public List<String> getComputerNumbers() {
		return computerNumbers;
	}
}
