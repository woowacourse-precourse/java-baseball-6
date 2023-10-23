package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import static baseball.utils.Constants.*;

public class Computer {
    private int[] digitPositions;
    private final int[] answerSequence;

    public Computer() {
        this.answerSequence = new int[BALL_MAX];
    }

    public void setAnswer() {
        this.setAnswerSequence();
        this.setDigitPositions();
    }

    private void setAnswerSequence() {
        boolean[] exist = new boolean[RANGE_END];
        Arrays.fill(exist, false);

        int times = 0;

        while(times < BALL_MAX) {
            int v = Randoms.pickNumberInRange(ZERO+1, RANGE_END-1);
            if(!exist[v]) {
                this.answerSequence[times] = v;
                exist[v] = true;
                times += 1;
            }
        }
    }

    private void setDigitPositions() {
        this.digitPositions = new int[RANGE_END];
        Arrays.fill(digitPositions, INIT_VALUE);

        // [-1, 2, -1, 0, -1, -1, -1, -1, -1, 1]
        for(int i=0; i<BALL_MAX; i++) {
            int position = answerSequence[i];
            digitPositions[position] = i;
        }
    }

    public int[] getDigitPositions() {
        return digitPositions;
    }
}
