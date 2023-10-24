package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import static baseball.Utils.*;

public class Oppoent {

    private static final boolean VALID_SUCCESS = true;
    private static final boolean VALID_FAILED = false;
    List<Integer> randomNumbers;

    public Oppoent() {}

    public void initialiser() {
        do{
            generateRandomNumber();
        } while (validateNumbers(randomNumbers) == VALID_FAILED);
    }

    private void generateRandomNumber() {
        randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < DESIGNED_NUM) {
            int number = Randoms.pickNumberInRange(START_NUM, LAST_NUM);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
    }

    private boolean validateNumbers(List<Integer> numbers) {
        if (numbers.size() != DESIGNED_NUM) {
            return VALID_FAILED;
        }
        for (int i = 0; i < DESIGNED_NUM; i++) {
            if (numbers.get(i) < START_NUM || numbers.get(i) > LAST_NUM) {
                return VALID_FAILED;
            }
        }
        if (numbers.stream().distinct().count() != DESIGNED_NUM) {
            return VALID_FAILED;
        }
        return VALID_SUCCESS;
    }

    public int checkStrike(List<Integer> userNumbers) {
        int strike = 0;
        for (int i = 0; i < DESIGNED_NUM; i++) {
            if (userNumbers.get(i).equals(randomNumbers.get(i)))
                strike++;
        }
        return strike;
    }

    public int checkBall(List<Integer> userNumbers) {
        int ball = 0;
        for (int i = 0; i < DESIGNED_NUM; i++) {
            if (randomNumbers.get(i).equals(userNumbers.get(i))) continue;
            if (userNumbers.contains(randomNumbers.get(i))) ball++;
        }
        return ball;
    }
}
