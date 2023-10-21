package baseball.domain;

import static baseball.constant.GameConstant.INPUT_NUMBER_SIZE;
import static baseball.constant.GameConstant.LAST_RANGE;
import static baseball.constant.GameConstant.RANDOM_NUMBER_SIZE;
import static baseball.constant.GameConstant.START_RANGE;
import static baseball.validator.GameValidator.errorValidate;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> number = new ArrayList<>();
    
    public void inputUserNumber(String inputNumber) {
        number.clear();
        stringToIntegerList(inputNumber);
    }

    public void createComputerNumber() {
        number.clear();
        while (number.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, LAST_RANGE);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        System.out.println(number);
    }

    public void inputCheck(Number inputNumber, GameResult gameResult) {
        gameResult.gameResultInit(ballCheck(inputNumber), strikeCheck(inputNumber));
    }

    private void stringToIntegerList(String inputNumber) {
        errorValidate(inputNumber);
        for (char charNumber : inputNumber.toCharArray()) {
            number.add(Character.getNumericValue(charNumber));
        }
    }

    private boolean isBall(int compareValue, int index) {
        return (number.contains(compareValue)) && (number.indexOf(compareValue) != index);
    }

    private boolean isStrike(int CompareValue, int index) {
        return number.indexOf(CompareValue) == index;
    }

    private int strikeCheck(Number compareNumber) {
        int strikeCount = 0;
        for (int i = 0; i < INPUT_NUMBER_SIZE; i++) {
            if (compareNumber.isStrike(number.get(i), i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private int ballCheck(Number compareNumber) {
        int ballCount = 0;
        for (int i = 0; i < INPUT_NUMBER_SIZE; i++) {
            if (compareNumber.isBall(number.get(i), i)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }


}
