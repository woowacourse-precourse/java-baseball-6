package baseball;

import camp.nextstep.edu.missionutils.Randoms; //랜덤 값 추출: pickNumberInRange()

public class ComNumber {
    int[] comNumber = new int[3];

    public makeComNumber() {
        for (int i = 0; i < 3; i++) {
            comNumber[i] = Randoms.pickNumberInRange(1, 9);
        }
    }
    
}