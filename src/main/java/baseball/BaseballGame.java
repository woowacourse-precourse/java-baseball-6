package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGame {
    private static final String RESTART = "1";
    private static final String QUIT = "2";
    private static final String REQUIRED_ONE_OR_TWO = "입력 값은 1또는 2여야 합니다.";
    private static final String REQUIRED_THREE_DIGITS = "입력 값은 3자리 숫자여야 합니다.";
    private static final int DIGIT_LENGTH = 3;
    private static final int DIGIT_MINIMUM = 1;
    private static final int DIGIT_MAXIMUM = 9;
    List<Integer> randomThreeDigits;

    BaseballGameLogic baseballGameLogic = new BaseballGameLogic();
    BaseballGameView baseballGameView = new BaseballGameView();

    public BaseballGame() {

    }

    public void start() {
        boolean isRestart = true;

        while (isRestart) {
            randomThreeDigits = baseballGameLogic.getThreeDigitNonZero();
            baseballGameView.printStartMessage();
            play();
            baseballGameView.printRestartMessage();
            isRestart = askRestart();
        }
    }

    private void play() {
        boolean isThreeStrike = false;

        while (!isThreeStrike){
            baseballGameView.printInputGuideMessage();

            String threeDigitsInput = getThreeDigitsInput();
            List<Integer> playerNumbers = baseballGameLogic.changeStringToDigit(threeDigitsInput);

            BallCount ballCount = baseballGameLogic.checkBallCount(randomThreeDigits, playerNumbers);
            baseballGameView.printBallCount(ballCount);

            if(ballCount.getStrike() == DIGIT_LENGTH){
                baseballGameView.printEndMessage();
                isThreeStrike = true;
            }
        }
    }

    private String getThreeDigitsInput(){
        String threeDigitsInput = Console.readLine();
        validateThreeDigits(threeDigitsInput);
        return threeDigitsInput;
    }

    private void validateThreeDigits(String input) {
        if (!input.matches("\\d{3}")) {
            throw new IllegalArgumentException(REQUIRED_THREE_DIGITS);
        }
    }

    private String getRestartInput(){
        String input = Console.readLine();
        validateIsOneOrTwo(input);
        return input;
    }

    private void validateIsOneOrTwo(String input){
        if(input.equals(RESTART) || input.equals(QUIT))
            return;
        throw new IllegalArgumentException(REQUIRED_ONE_OR_TWO);
    }

    private boolean askRestart(){
        String restartInputNumber = getRestartInput();
        return !restartInputNumber.equals(QUIT);
    }
}
