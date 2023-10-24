package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Check {
	public List<Integer> ready() {
		List<Integer> comNum = new ArrayList<>();

		while (comNum.size() < Constants.DIGIT_SIZE) {
			int randomNum = Randoms.pickNumberInRange(Constants.START_RANGE, Constants.END_RANGE);
			if (!comNum.contains(randomNum)) {
				comNum.add(randomNum);
			}
		}
		return comNum;
	}
	

	public void checkCondition(String str) {
		isRightLength(str);
		isRightDigit(str);
		isNotDuplicate(str);
	}

	private void isRightLength(String str) {
		if (str.length() != Constants.DIGIT_SIZE)
			throw new IllegalArgumentException(Constants.WRONG_LENGTH_ERROR);
	}

	private void isRightDigit(String str) {
		String tmp = "^[1-9]*$";
		if (Pattern.matches(tmp, str) != true)
			throw new IllegalArgumentException(Constants.WRONG_INPUT_ERROR);
	}

	private void isNotDuplicate(String str) {
		for (int i = 0; i < str.length(); i++) {
			int firstInd = str.indexOf(str.charAt(i));
			if (firstInd != i)
				throw new IllegalArgumentException(Constants.WRONG_INPUT_ERROR);
		}
	}

	public List<Integer> setInputNum(String str) {
		List<Integer> tmp = new ArrayList<>();
		for (int j = 0; j < str.length(); j++) {
			int num = Character.getNumericValue(str.charAt(j));
			tmp.add(num);
		}
		return tmp;
	}
}
