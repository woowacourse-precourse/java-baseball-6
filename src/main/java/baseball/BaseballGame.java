package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class BaseballGame {
    private final Output output = new Output();

    private final ArrayList<Integer> userNumbers = new ArrayList<>();
    private final ArrayList<Integer> targetNumbers = new ArrayList<>();
    private int strike;
    private int ball;

    public void playBaseballGame() {
        setTargetNumbers();
        while(strike!=3) {
            inputUserNumbers();
            countStrikeAndBall();
        }
        restartGame();
    }

    private void setTargetNumbers() {
        while(targetNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
            }
        }
        System.out.println(targetNumbers);
    }

    private void resetStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private void inputUserNumbers() {
        userNumbers.clear();
        resetStrikeAndBall();
        output.printInputMessage();
        String inputtedNumber = inputStringNumber();
        checkInputtedNumber(inputtedNumber);
        convertStringToIntegerList(inputtedNumber);
    }

    private String inputStringNumber() {
        return Console.readLine();
    }

    private void checkInputtedNumber(String inputtedNumber) {
        checkNumbersDigit(inputtedNumber);
        checkNumbersDuplicate(inputtedNumber);
    }

    private void checkNumbersDigit(String inputtedNumber) {
        if(inputtedNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersDuplicate(String inputtedNumber) {
        String stringForCheckingDuplicate = "";
        for (char number : inputtedNumber.toCharArray()) {
            if(stringForCheckingDuplicate.contains(String.valueOf(number))) {
                throw new IllegalArgumentException();
            }
            stringForCheckingDuplicate += number;
        }
    }

    private void convertStringToIntegerList(String inputtedNumber) {
        for(int numbersIndex=0; numbersIndex<3; numbersIndex++) {
            char digitChar = inputtedNumber.charAt(numbersIndex);
            int digitNumber = Character.getNumericValue(digitChar);
            userNumbers.add(digitNumber);
        }
    }

    private void countStrikeAndBall() {
        countStrike(userNumbers);
        countBall(userNumbers);
        output.printStrikeBallMessage(strike, ball);
    }

    private void countStrike(ArrayList<Integer> userNumbers) {
        for(int numbersIndex=0; numbersIndex<3; numbersIndex++) {
            if(userNumbers.get(numbersIndex).equals(targetNumbers.get(numbersIndex))) {
                strike++;
            }
        }
    }

    private void countBall(ArrayList<Integer> userNumbers) {
        for(int numbersIndex=0; numbersIndex<3; numbersIndex++) {
            if(targetNumbers.contains(userNumbers.get(numbersIndex)) &
                    !targetNumbers.get(numbersIndex).equals(userNumbers.get(numbersIndex))) {
                ball++;
            }
        }
    }

    private void restartGame() {
        resetAllGameElement();
        output.printSelectRestartMessage();
        String restartOption = inputRestartOption();
        if(restartOption.equals("1")) {
            playBaseballGame();
        }
    }

    private void resetAllGameElement() {
        targetNumbers.clear();
        userNumbers.clear();
        strike=0;
        ball=0;
    }

    private String inputRestartOption() {
        return Console.readLine();
    }
}
