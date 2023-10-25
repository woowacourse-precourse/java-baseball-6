package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public final List<Integer> answer;

    public Computer() {
        answer = generate();
    }
    public List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public Rule getResult(List<Integer> playerNumList) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(playerNumList.get(i))) {
                strike++;
            } else if (answer.contains(playerNumList.get(i))) {
                ball++;
            }
        }
        return new Rule(strike, ball);
    }
}
