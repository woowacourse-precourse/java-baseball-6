package baseball.view;

import baseball.utils.InputValidation;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
	private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

	public List<Integer> readNumber() {
		System.out.print(INPUT_NUMBER);
		String input = InputValidation.validate(inputNumber());
		return convertStringToInteger(input);
	}
	public static String inputNumber(){
		return Console.readLine();
	}
	public static List<Integer> convertStringToInteger(String input){
		return Arrays.stream(input.split(""))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}