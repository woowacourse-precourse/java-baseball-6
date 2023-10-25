package player;

import camp.nextstep.edu.missionutils.Randoms;
import judge.Result;

public class Computer implements Player {
    private char[] number;

    public Computer() {
        number = new char[SIZE];
    }

    @Override
    public void setNumbers() {
        number = pickNumbers();
    }

    public Result compare(final int comparedIdx, final char comparedChar) {

        Result result = Result.NOTHING;
        for (int idx = 0; idx < SIZE; idx++) {
            if (comparedChar != number[idx]) {
                continue;
            }

            if (idx != comparedIdx) {
                result = Result.BALL;
            } else {
                result = Result.STRIKE;
            }

            break;
        }

        return result;
    }

    private char[] pickNumbers() {
        boolean[] alreadyExist = new boolean[10];
        char[] randomNumbers = new char[SIZE];

        int idx = 0;
        while (idx < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (alreadyExist[randomNumber]) {
                continue;
            }

            randomNumbers[idx++] = (char) ('0' + randomNumber);
            alreadyExist[randomNumber] = true;
        }

        return randomNumbers;
    }
}

