package Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {
    private static ArrayList<Integer> Answer;

    public Computer() {
        this.CreateAnswer();
    }

    public void CreateAnswer() {
        Answer = new ArrayList<>();
        while (Answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Answer.contains(randomNumber)) {
                Answer.add(randomNumber);
            }
        }
    }

    public ArrayList<Integer> getAnswer() {
        return Answer;
    }
}
