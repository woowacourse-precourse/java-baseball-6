package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class Player_Number { // 사용자 입력 기능
	private static final String lengthErr_str = "세자리 수를 입력해 주세요.";
	private static final String duplicationErr_str = "중복되지 않은 수를 입력하세요.";
	private static final String DigitErr_str = "자연수를 입력하세요.";
	private String Player_Number;

	public String getPlayer_Number() {

        return Player_Number;
    }
	
	// 뷰에서 사용자 입력을 받아 사용.
	public Player_Number(String Player_Number) {

		isCorrectNumber(Player_Number);
		isDigitNumber(Player_Number);
		lengthCheck(Player_Number);

		this.Player_Number = Player_Number;
		
	}


	// 중복있나 체크
	public static void isCorrectNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			duplicationCheck(input);
		}
	}

	// 중복 체크
	public static void duplicationCheck(String input) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() != input.length()) {
			throw new IllegalArgumentException(duplicationErr_str);
		}

	}

	// 자연수인지 체크
	public static void isDigitNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			DigitCheck(input, i);
		}
	}

	// 자연수 체크 메서드
	public static void DigitCheck(String input, int idx) {
		if (!Character.isDigit(input.charAt(idx))) {
			throw new IllegalArgumentException(DigitErr_str);
		}
	}

	// 길이 체크
	public void lengthCheck(String input) {
		if (input.length() != 3) {
			throw new IllegalArgumentException(lengthErr_str);
		}
	}

}
