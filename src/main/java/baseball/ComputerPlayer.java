package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;


public class ComputerPlayer {

    public static int[] generateRandomNumber() {

        List<Integer> computer = new ArrayList<>();
        int[] number = new int[3];

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int i = 0; i < 3; i++) {
            number[i] = computer.get(i);
        }
        
        return number;
    }
}
