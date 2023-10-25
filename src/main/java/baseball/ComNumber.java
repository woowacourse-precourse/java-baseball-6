package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;


public class ComNumber {
    int[] comNumber = new int[3];

    public void makeComNumber() {
        Randoms.pickNumberInRange(1, 9);
    }
    
}