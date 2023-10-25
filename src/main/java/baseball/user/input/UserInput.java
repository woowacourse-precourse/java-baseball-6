package baseball.user.input;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    /**
     * 사용자가 숫자 3개를 입력
     *
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
     *
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
     *
     * @param str
     * @return 공백을 제거하고난 후 문자열
     */
    private String removeSpace(String str) {
        return str.replace(" ", "");
    }

    /**
     * 숫자 3개를 입력할 때 유효한지 검사
     */
    public void validateGetGamingInput(String input) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkThreeNumber(input);
        inputValidator.checkOnlyCompositionNumber(input);
        inputValidator.checkDuplicationNumber(input);
    }

    /**
     * 1 또는 2가 아닌지에 대한 유효성 검사
     */
    public void validateGetEndGameInput(String input) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkOnlyTwoNumber(input);
    }

}
