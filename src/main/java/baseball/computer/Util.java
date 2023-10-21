package baseball.computer;

public class Util {
	public static void checkUserNum(String UserNum) {
		if (UserNum.length() !=3) {
			throw new IllegalArgumentException("프로그램을 종료합니다.");
		}
	}

	public static void checkChoiceNum(String choice) {
		if (!choice.equals("1") || !choice.equals("2")) {
			throw new IllegalArgumentException("프로그램을 종료합니다.");
		}
	}
}
