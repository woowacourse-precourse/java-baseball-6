package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;

public class Input {
	final String ERROR = "[ERROR]";
	public int[] getUserInput() throws IllegalArgumentException{
		String input = readLine();
		validateInput(input);
		return transformInput(input);
	}

	private void validateInput(String input) throws IllegalArgumentException{
		isThreeNumber(input);
		isNumber(input);
		isNotDuplicate(input);
	}

	public void isNotDuplicate(String input) {
		HashSet<String> uniqueValue = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			uniqueValue.add(String.valueOf(input.charAt(i)));
		}
		if (uniqueValue.size() != 3) throw new IllegalArgumentException(ERROR + " 중복된 값은 입력이 불가능 합니다.");
	}

	public void isNumber(String input) {
		if (!input.matches("\\d+")) throw new IllegalArgumentException(ERROR + " 숫자만 입력 가능합니다.");
	}

	private void isThreeNumber(String input) {
		if (!(input.length() == 3)) throw new IllegalArgumentException(ERROR + " 3개의 숫자를 입력해주세요");
	}

	private int[] transformInput(String input) {
		return charArrToIntArr(stringToCharArr(input));
	}
	private char[] stringToCharArr(String input){
		char[] transformedInput = new char[input.length()];
		for (int i = 0; i < input.length(); i++){
			transformedInput[i] = input.charAt(i);
		}
		return transformedInput;
	}
	private int[] charArrToIntArr(char[] transformedInput){
		int[] userNumber = new int[transformedInput.length];
		for (int i = 0; i < transformedInput.length; i++) {
			userNumber[i] = Character.getNumericValue(transformedInput[i]);
		}
		return userNumber;
	}
	public boolean isRestart(){
		String confirmation = readLine();
		return Integer.parseInt(confirmation) == 1;
	}

}
