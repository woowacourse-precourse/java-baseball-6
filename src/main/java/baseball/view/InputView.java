package baseball.view;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	public List<Integer> createPlayerNumber() {
		System.out.println(NUMBER_INPUT_MESSAGE);
		String input = Console.readLine();
		return input.chars()
			.mapToObj(Character::getNumericValue)
			.collect(Collectors.toList());
	}


}
