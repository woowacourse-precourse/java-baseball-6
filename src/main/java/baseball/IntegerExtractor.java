package baseball;

public class IntegerExtractor {
	String str;
	int number;
	public int validateNumber() {
		// 숫자 검증
		try {
			number = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		return number;
	}
}
