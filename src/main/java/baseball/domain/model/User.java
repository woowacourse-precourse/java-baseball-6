package baseball.domain.model;

import baseball.global.util.ValidateInputUtil;

import java.util.ArrayList;
import java.util.List;

public class User {
	private List<Integer> expectedNumberList;

	public void setExpectedNumber(String inputNumber) {
		expectedNumberList = new ArrayList<>();
		ValidateInputUtil.validateInputNumberIsValid(inputNumber);
		parseInput(inputNumber);
	}

	private void parseInput(String inputNumber){
		for (char inputCharacter : inputNumber.toCharArray()) {
			expectedNumberList.add(Character.getNumericValue(inputCharacter));
		}
	}

	public List<Integer> getExpectedNumberList() {
		return expectedNumberList;
	}
}
