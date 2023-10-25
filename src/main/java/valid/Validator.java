package valid;

import game.Message;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public Validator(String playerInputNumber) {
		validOnlyNumbers(playerInputNumber);
		validDecidedSize(playerInputNumber);
		validDuplicated(playerInputNumber);
	}

	//숫자만 허용
	public void validOnlyNumbers(String playerInputNumber) throws IllegalArgumentException {
		String regex = "^[0-9]+$";

		// 정규 표현식 패턴을 컴파일
		Pattern pattern = Pattern.compile("^[0-9]+$");
		// 입력 문자열과 패턴을 비교
		//Matcher matcher = pattern.matcher(playerInputNumber);

		if (!pattern.matcher(playerInputNumber).matches()) {
			throw new IllegalArgumentException(Message.INPUT_NUMBER_VALID);
		}
	}

	//세자리수만 허용
	public void validDecidedSize(String playerInputNumber) throws IllegalArgumentException {
		if (playerInputNumber.length() != 3) {
			throw new IllegalArgumentException(Message.INPUT_SIZE_VALID);
		}
	}

	//중복 허용 X
	public void validDuplicated(String playerInputNumber) throws IllegalArgumentException {
		Set<Character> set = new HashSet<>();
		for (char eachNumber : playerInputNumber.toCharArray()) {
			set.add(eachNumber);
		}

		if (set.size() != playerInputNumber.length()) {
			throw new IllegalArgumentException(Message.INPUT_DUPLI_VALID);
		}
	}

}
