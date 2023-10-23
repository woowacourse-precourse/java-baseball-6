package player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer implements Player {
    private char[] number;

    //todo: number 초기화 고려
    public Computer() {
        number = new char[3];
    }

    @Override
    public void setNumber() {
        List<Integer> randomList = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        int idx = 0;
        for (int random : randomList) {
            number[idx++] = (char) (random + '0');
        }
    }

    /**
     * <p>0: nothing</p>
     * <p>1: ball</p>
     * <p>2: strike</p>
     */
    public int compare(int comparedIdx, char comparedChar) {

        int result = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (comparedChar != number[idx])
                continue;

            if (idx != comparedIdx)
                result = 1;
            else
                result = 2;

            break;
        }

        return result;
    }
}
