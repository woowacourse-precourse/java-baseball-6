package baseball.domain.Validator;

import java.util.HashSet;


public class PlayerInputValidator {

    public void validAnswerNumber(String playerInput) {
        if (playerInput.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자만 입력해주세요.");
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < playerInput.length(); i++) {
            if (!(playerInput.charAt(i) >= '1' && playerInput.charAt(i) <= '9')) {
                throw new IllegalArgumentException("1부터 9사이의 숫자만 입력해주세요.");
            }
            if (!set.add(playerInput.charAt(i))) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요");
            }
        }
    }

    public void validRestartNumber(String playerInput) {
        if (!(playerInput.equals("1") || playerInput.equals("2"))) {
            throw new IllegalArgumentException("1자리의 숫자만 입력해주세요.");
        }
    }
}
