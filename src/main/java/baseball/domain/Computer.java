package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    int order = 1;
    int[] goal = new int[10];

    public Computer() {
        while (order < 4) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (goal[randomNum] == 0) {
                goal[randomNum] = order;
                order += 1;
            }
        }
    }

    public int[] getGoal() {
        return goal;
    }
}
