package player;

import camp.nextstep.edu.missionutils.Randoms;
import judge.Result;

import java.util.List;

import static judge.Result.*;

public class Computer implements Player {
    private char[] number;

    public Computer() {
        number = new char[3];
    }

    @Override
    public void setNumbers() {
        number = pickNumbers();
    }

    private char[] pickNumbers() {
        boolean[] alreadyExist = new boolean[10];
        char[] randomNumbers = new char[3];

        int idx = 0;
        while (idx < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (alreadyExist[randomNumber])
                continue;

            randomNumbers[idx++] = (char) ('0' + randomNumber);
            alreadyExist[randomNumber] = true;
        }

        return randomNumbers;
    }

    private char[] shuffleNumbers() {
        List<Integer> randomList = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        char[] randomNumbers = new char[3];
        for (int i = 0; i < 3; i++) {
            randomNumbers[i] = (char) (randomList.get(i) + '0');
        }

        return randomNumbers;
    }

    public Result compare(int comparedIdx, char comparedChar) {

        Result result = Result.NOTHING;
        for (int idx = 0; idx < 3; idx++) {
            if (comparedChar != number[idx])
                continue;

            if (idx != comparedIdx)
                result = BALL;
            else
                result = STRIKE;

            break;
        }

        return result;
    }
}

