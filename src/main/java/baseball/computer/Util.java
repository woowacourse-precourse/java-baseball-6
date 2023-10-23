package baseball.computer;

public class Util {
	public static void checkUserNum(String UserNum) {
		if (UserNum.length() !=3) {
			throw new IllegalArgumentException("프로그램을 종료합니다.");
		}
	}


	public static void checkChoiceNum(int choice) {
		if (choice>2||choice<1) {
			throw new IllegalArgumentException("프로그램을 종료합니다.");
		}
	}

	public static void checkSameUum(String UserNum) {
		for (int i = 1; i < 3; i++) {
			if (UserNum.charAt(i - 1) == UserNum.charAt(i))
				throw new IllegalArgumentException("프로그램을 종료합니다.");
		}
	}
}
