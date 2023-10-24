package baseball.global;

public class Validator {

	public static void validateRestart(String input) {
		if (!input.equals("1") && !input.equals("2"))
			throw new IllegalArgumentException("옵션 입력을 잘못하였습니다.");
	}
}
