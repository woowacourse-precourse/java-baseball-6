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
    BaseballGameView baseballGameView = new BaseballGameView();

    public BaseballGame() {

    }

    public void start() {
        boolean isRestart = true;

        while (isRestart) {
            randomThreeDigits = getThreeDigitNonZero();
            baseballGameView.printStartMessage();
            play();
            baseballGameView.printRestartMessage();
            isRestart = askRestart();
        }
    }

    private List<Integer> getThreeDigitNonZero(){
        List<Integer> threeDigitNonZero = new ArrayList<>();

        while (threeDigitNonZero.size() < DIGIT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(DIGIT_MINIMUM, DIGIT_MAXIMUM);
            if (!threeDigitNonZero.contains(randomNumber)) {
                threeDigitNonZero.add(randomNumber);
            }
        }

        return threeDigitNonZero;
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

    private BallCount checkBallCount(List<Integer> randomThreeDigits, List<Integer> inputDigits){
        int strike = 0;
        int ball = 0;
        BallCount ballCount = new BallCount();

        for(int i = 0; i < DIGIT_LENGTH; i++){
            if(Objects.equals(randomThreeDigits.get(i), inputDigits.get(i))){
                strike ++;
                continue;
            }

            if(randomThreeDigits.contains(inputDigits.get(i))){
                ball ++;
            }
        }

        ballCount.setStrike(strike);
        ballCount.setBall(ball);

        return ballCount;
    }

    private void play() {
        boolean isThreeStrike = false;

        while (!isThreeStrike){
            baseballGameView.printInputGuideMessage();

            String threeDigitsInput = getThreeDigitsInput();
            List<Integer> playerNumbers = changeStringToDigit(threeDigitsInput);

            BallCount ballCount = checkBallCount(randomThreeDigits, playerNumbers);
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
