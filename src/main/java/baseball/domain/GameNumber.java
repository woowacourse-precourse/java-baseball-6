package baseball.domain;

import baseball.validate.InvalidInputException;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GameNumber {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int START_RANDOM_NUMBER = 1;
    private static final int END_RANDOM_NUMBER = 9;

    private static final InvalidInputException invalidInputException = new InvalidInputException();


    private List<Integer> number = new ArrayList<>();

    public GameNumber() {
        setComputerNumber();
    }

    public GameNumber(String inputNum, int size) {
        invalidInputException.checkInputForGame(inputNum, size);
        setPlayerNumber(inputNum);
    }

    public List<Integer> getNumber() {
        return number;
    }

    private void setPlayerNumber(String inputNum) {
        for (String num : inputNum.split("")) {
            number.add(Integer.parseInt(num));
        }
    }

    private void setComputerNumber() {
        while (number.size() < GAME_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }
}
