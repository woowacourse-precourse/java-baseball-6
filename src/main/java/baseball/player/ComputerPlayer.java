package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class ComputerPlayer {
    private static final int startInclusive = 1;
    private static final int endInclusive = 9;
    private static final int digits = 3;
    private HashSet<Integer> computer = new HashSet<>();

    public ComputerPlayer() {
        pickNumber();
    }

    public void pickNumber() {
        clear();
        while(computer.size() < digits) {
            int randomNum = Randoms.pickNumberInRange(startInclusive, endInclusive);
            computer.add(randomNum);
        }
    }

    public void clear() {
        this.computer.clear();
    }
}
