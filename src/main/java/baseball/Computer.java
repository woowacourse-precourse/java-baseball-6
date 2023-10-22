package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answer = new ArrayList<>();

    Computer() {

    }

    public void printMsg(String msg) {
        System.out.print(msg);
    }

    public void makeAnswer() {
        while (answer.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(num))
                answer.add(num);
        }
    }

    public void makeResult(String input) {

    }

    public boolean checkAnswer() {

        return true;
    }
}
