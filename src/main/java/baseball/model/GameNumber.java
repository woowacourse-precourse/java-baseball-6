package baseball.model;

import static baseball.model.Constants.MAX_VALUE;
import static baseball.model.Constants.MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameNumber {

    List<Integer> gameNumbers = new ArrayList<>();

    public void createRandomNumbers() {
        gameNumbers.clear();
        while (gameNumbers.size() < 3) {
            int randomNumber = createRandomNumber();
            checkRandomNumber(randomNumber);
        }
    }

    private int createRandomNumber() {
        return (Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
    }

    private void checkRandomNumber(int randomNumber) {
        if (isUnique(randomNumber)) {
            gameNumbers.add(randomNumber);
        }
    }

    private boolean isUnique(int randomNumber) {
        if (gameNumbers.contains(randomNumber)) {
            return false;
        }
        return true;
    }

    public int getNumber(int index) {
        return gameNumbers.get(index);
    }
}
