package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static final int INPUT_LEN = 3;

    public String userAnswer;

    public UserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        userAnswer = Console.readLine();
        validate(userAnswer);
    }

    /**
     * 사용자 입력값에 대한 예외처리
     */
    private void validate(String input) throws IllegalArgumentException {
        validateLength(input);
        validateCharacter(input);
        validateDuplicate(input);
    }

    /**
     * 길이 3 아닌 경우
     */
    private void validateLength(String input) throws IllegalArgumentException {
        if (input.length() != INPUT_LEN) {
            throw new IllegalArgumentException("입력 길이가 잘못되었습니다.");
        }
    }

    /**
     * 입력값 각 숫자 범위가 1-9 외 구성인 경우
     */
    private void validateCharacter(String input) throws IllegalArgumentException {
        for (int i = 0; i < INPUT_LEN; i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("1-9 범위를 벗어난 입력입니다.");
            }
        }
    }

    /**
     * 입력값 중복된 경우-서로 다른 수가 아닌 경우
     */
    private void validateDuplicate(String input) throws IllegalArgumentException {
        String tmp = "";
        for (int i = 0; i < INPUT_LEN; i++) {
            String num = String.valueOf(input.charAt(i));
            if (tmp.contains(num)) {
                throw new IllegalArgumentException("중복된 입력입니다. 서로 다른 세가지 숫자가 입력되어야 합니다.");
            }
            tmp = tmp.concat(num);
        }
    }
}
