package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
	private List<Integer> userNumber;

	public UserNumber() {
		this.userNumber = List.of(0, 0, 0);
	}

	public List<Integer> getUserNumber() {
		return userNumber;
	}

	public void newUserNumber(String input){
		this.userNumber = stringToIntegerList(input);
	}

	private List<Integer> stringToIntegerList(String input){
		return input.chars()
			.map(Character::getNumericValue)
			.boxed()
			.collect(Collectors.toList());
	}
}
