package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    private int[] setting() {
        int order = 1;
        int[] computer = new int[10];
        while (order < 4) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (computer[randomNum] == 0) {
                computer[randomNum] = order;
                order += 1;
            }
        }
        return computer;
    }

    public void run() {
    }
}
