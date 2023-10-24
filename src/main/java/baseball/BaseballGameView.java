package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String FORMAT_BALL_STRIKE = "%d볼 %d스트라이크";
    private static final String FORMAT_BALL = "%d볼";
    private static final String FORMAT_STRIKE = "%d스트라이크";

    private static final String REQUIRED_ONE_OR_TWO = "입력 값은 1또는 2여야 합니다.";
    private static final String REQUIRED_THREE_DIGITS = "입력 값은 3자리 숫자여야 합니다.";
    private static final String REQUIRED_UNIQUE_DIGITS = "서로 다른 3자리의 숫자를 입력해야 합니다.";
    private static final String CONTAINS_ZERO_DIGITS = "0은 입력할 수 없습니다.";

    public BaseballGameView() {
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public String getPlayerNumbers() {
        System.out.print(INPUT_GUIDE_MESSAGE);
        return inputThreeDigits();
    }

    private String inputThreeDigits() {
        String threeDigitsInput = Console.readLine();
        validatePlayerGameNumber(threeDigitsInput);
        return threeDigitsInput;
    }

    private void validatePlayerGameNumber(String input) {
        validateThreeDigits(input);
        validateContainsZero(input);
        validateUniqueDigits(input);
    }

    private void validateThreeDigits(String input) {
        if (!input.matches("\\d{3}")) {
            throw new IllegalArgumentException(REQUIRED_THREE_DIGITS);
        }
    }

    private void validateUniqueDigits(String input) {
        int length = input.length();

        for (int i = 0; i < length - 1; i++) {
            char currentDigit = input.charAt(i);
            for (int j = i + 1; j < length; j++) {
                if (currentDigit == input.charAt(j)) {
                    throw new IllegalArgumentException(REQUIRED_UNIQUE_DIGITS); // 중복된 숫자가 존재
                }
            }
        }
    }

    private void validateContainsZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException(CONTAINS_ZERO_DIGITS);
        }
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }

    public String printBallCount(BallCount ballCount) {
        int strike = ballCount.getStrike();
        int ball = ballCount.getBall();
        String resultMessage;

        if (strike > 0 && ball > 0) {
            resultMessage = String.format(FORMAT_BALL_STRIKE, ball, strike);
            System.out.println(resultMessage);
            return resultMessage;
        }

        if (strike == 0 && ball > 0) {
            resultMessage = String.format(FORMAT_BALL, ball);
            System.out.println(resultMessage);
            return resultMessage;
        }

        if (strike > 0 && ball == 0) {
            resultMessage = String.format(FORMAT_STRIKE, strike);
            System.out.println(resultMessage);
            return resultMessage;
        }

        resultMessage = NOTHING;
        System.out.println(resultMessage);
        return resultMessage;
    }
}
