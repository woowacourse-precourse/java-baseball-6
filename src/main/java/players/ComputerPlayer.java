package players;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerPlayer {

    private static final int NUMBER_LENGTH = 3;
    private int[] number;

    public ComputerPlayer() {
        this.number = new int[NUMBER_LENGTH];
    }

    public int[] createNumber() {
        int cursor = 0;
        while (cursor < NUMBER_LENGTH) {
            int n = Randoms.pickNumberInRange(1, 9);
            if (!alreadyPicked(n)) {
                number[cursor++] = n;
            }
        }

        return this.number;
    }

    private boolean alreadyPicked(int n) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (this.number[i] == n) {
                return true;
            }
        }
        return false;
    }

}
