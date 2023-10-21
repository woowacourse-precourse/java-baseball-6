package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    private static final String RESTART = "1";
    private static final String QUIT = "2";
    private static final String REQUIRED_ONE_OR_TWO = "입력 값은 1또는 2여야 합니다.";
    private static final String REQUIRED_THREE_DIGITS = "입력 값은 3자리 숫자여야 합니다.";
    private static final int MAX_STRIKE = 3;

    BaseballGameLogic baseballGameLogic = new BaseballGameLogic();
    BaseballGameView baseballGameView = new BaseballGameView();

    public BaseballGame() {

    }

    public void start() {
        boolean isRestart = true;

        while (isRestart) {
            baseballGameView.printStartMessage();
            play(baseballGameLogic.getThreeDigitNonZero());
            baseballGameView.printRestartMessage();
            isRestart = askRestart();
        }
    }

    private void play(List<Integer> randomThreeDigits) {
        boolean isThreeStrike = false;

        while (!isThreeStrike){
            baseballGameView.printInputGuideMessage();

            String threeDigitsInput = getThreeDigitsInput();
            List<Integer> playerNumbers = baseballGameLogic.changeStringToDigit(threeDigitsInput);

            BallCount ballCount = baseballGameLogic.checkBallCount(randomThreeDigits, playerNumbers);
            baseballGameView.printBallCount(ballCount);

            if(ballCount.getStrike() == MAX_STRIKE){
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
