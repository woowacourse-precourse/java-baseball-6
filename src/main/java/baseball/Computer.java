package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    ArrayList<Integer> makeAnswer() {
        ArrayList<Integer> answer;
        int randomNumber;

        answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            answer.add(randomNumber);
        }
        return (answer);
    }
}
