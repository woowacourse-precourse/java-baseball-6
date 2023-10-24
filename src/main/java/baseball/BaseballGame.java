package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final String RESTART = "1";
    private static final String QUIT = "2";
    private static final String REQUIRED_ONE_OR_TWO = "입력 값은 1또는 2여야 합니다.";
    private static final String REQUIRED_THREE_DIGITS = "입력 값은 3자리 숫자여야 합니다.";
    private static final String REQUIRED_UNIQUE_DIGITS = "서로 다른 3자리의 숫자를 입력해야 합니다.";
    private static final String CONTAINS_ZERO_DIGITS = "0은 입력할 수 없습니다.";
    private static final int MAX_STRIKE = 3;
    private final BaseballGameLogic baseballGameLogic;
    private final BaseballGameView baseballGameView;

    public BaseballGame() {
        baseballGameLogic = new BaseballGameLogic();
        baseballGameView = new BaseballGameView();
    }

    public void start() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            baseballGameView.printStartMessage();
            playUntilThreeStrikes(baseballGameLogic.getRandomThreeDigitNonZero());
            baseballGameView.printRestartMessage();
            keepPlaying = inputRestartOrQuit();
        }
    }

    private void playUntilThreeStrikes(List<Integer> randomThreeDigits) {
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            baseballGameView.printInputGuideMessage();

            BallCount ballCount = baseballGameLogic.checkBallCount(
                    randomThreeDigits,
                    changeStringToDigit(inputThreeDigits())
            );

            baseballGameView.printBallCount(ballCount);

            if (ballCount.getStrike() == MAX_STRIKE) {
                baseballGameView.printEndMessage();
                isThreeStrike = true;
            }
        }
    }

    private List<Integer> changeStringToDigit(String numberFromPlayer) {
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < numberFromPlayer.length(); i++) {
            char digitChar = numberFromPlayer.charAt(i); // 각 자리의 문자를 가져옴
            int digit = Character.getNumericValue(digitChar); // 문자를 정수로 변환
            digitList.add(digit); // 정수를 리스트에 추가
        }

        return digitList;
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

    private boolean inputRestartOrQuit() {
        String input = Console.readLine();
        validateIsOneOrTwo(input);
        return input.equals(RESTART);
    }

    private void validateIsOneOrTwo(String input) {
        if (input.equals(RESTART) || input.equals(QUIT))
            return;
        throw new IllegalArgumentException(REQUIRED_ONE_OR_TWO);
    }
}
