package baseball.user.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class UserInput {
    /**
     * 사용자가 숫자 3개를 입력
     * @return 숫자 3개(String)
     */
    public String getGamingInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = removeSpace(Console.readLine());

        validateGetGamingInput(userInput);

        return userInput;
    }

    /**
     * 사용자가 게임을 새로 시작하려면 1, 종료하려면 2를 입력
     * @return 숫자 1 또는 2 (String)
     */
    public String getEndGameInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = removeSpace(Console.readLine());

        validateGetEndGameInput(userInput);

        return userInput;
    }

    /**
     * 사용자 입력에서 공백 제거
     * @param str
     * @return 공백을 제거하고난 후 문자열
     */
    private String removeSpace(String str) {
        return str.replace(" ", "");
    }

    /**
     * 숫자 3개를 입력할 때 유효한지 검사
     */
    private void validateGetGamingInput(String input) {
        checkThreeNumber(input);
        checkOnlyCompositionNumber(input);
        checkDuplicationNumber(input);
    }

    /**
     * 1 또는 2가 아닌지에 대한 유효성 검사
     */
    private void validateGetEndGameInput(String input) {
        checkOnlyTwoNumber(input);
    }

    /**
     * 세 개의 숫자가 아니라면 IllegalArgumentException 발생
     */
    private void checkThreeNumber(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("세 개의 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 1~9 사이의 숫자가 아니면 IllegalArgumentException 발생
     */
    private void checkOnlyCompositionNumber(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("입력된 값은 1~9 사이의 숫자만 가능합니다.");
            }
        }
    }

    /**
     * 중복된 숫자가 있다면 IllegalArgumentException 발생
     */
    private void checkDuplicationNumber(String input) {
        Set<Character> uniqueNumbers = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (uniqueNumbers.contains(c)) {
                throw new IllegalArgumentException("입력된 숫자에 중복된 값이 있습니다.");
            }
            uniqueNumbers.add(c);
        }
    }

    /**
     * 1 또는 2가 아니라면 IllegalArgumentException 발생
     */
    private void checkOnlyTwoNumber(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
