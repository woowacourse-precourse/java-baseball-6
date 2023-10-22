package baseball.domain.player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputerPlayer {
    public static List<Integer> computer = new ArrayList<>();
    public static void setComputerNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static int[] getComputerNumber() {
        int[] computerIntArray = Arrays.stream(computer.toArray()).mapToInt(i -> (int) i).toArray();
        return computerIntArray;
    }
}
