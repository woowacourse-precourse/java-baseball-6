package baseball;

import java.util.HashSet;
import java.util.Set;

public class ExceptionCheck {
		
		public static String playerNumberCheck(String playerInput) {
			inputLengthCheck(playerInput);
			separateInputValues(playerInput);
			inputDuplicationCheck(playerInput);
			return playerInput;	
		}
		
		private static void inputLengthCheck(String playerInput) throws IllegalArgumentException {
			if (playerInput.length() != 3) {
				throw new IllegalArgumentException("잘못된 값 입력 : 숫자 3개를 입력해주세요.");
			}
		}
				
		private static void separateInputValues(String playerInput) {
			for (int i = 0; i < (playerInput.length()); i++) {
				inputDigitCheck(playerInput.charAt(i));
				inputNumRangeCheck(Character.getNumericValue(playerInput.charAt(i)));
			}	
		}
		
		private static void inputDigitCheck(char playerInput) throws IllegalArgumentException {
			if (!Character.isDigit(playerInput)) {
				throw new IllegalArgumentException("잘못된 값 입력 : 숫자만 입력 가능합니다.");
			}
		}
	
		private static void inputNumRangeCheck(int playerInput) throws IllegalArgumentException {
			if (playerInput < 1 || playerInput > 9) {
				throw new IllegalArgumentException("잘못된 값 입력 : 각 숫자는 1부터 9까지의 수여야 합니다.");
			}
		}
		
		private static void inputDuplicationCheck(String playerInput) throws IllegalArgumentException {
			Set<Character> tmp = new HashSet<>();
			
			for (int i = 0; i < playerInput.length(); i++) {
				tmp.add(playerInput.charAt(i));
			}
			if (tmp.size() != playerInput.length()) {
				throw new IllegalArgumentException("잘못된 값 입력 : 각 숫자는 중복되지 않아야 합니다.");
			}
		}
		
		public static String playerSelectCheck(String playerInput) {
			correctNumberCheck(playerInput);
			return playerInput;
		}
		
		public static void correctNumberCheck(String playerInput) throws IllegalArgumentException {
			if (!playerInput.equals("1") && !playerInput.equals("2")) {
				throw new IllegalArgumentException("잘못된 값 입력 : 1 또는 2를 입력해주세요.");
			}
		}
}
