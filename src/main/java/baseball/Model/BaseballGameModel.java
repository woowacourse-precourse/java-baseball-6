package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameModel {
    private int[] answer;

    public BaseballGameModel() {
        generateRandomAnswer();
    }

    public void generateRandomAnswer() {
        answer = new int[3];
        List<Integer> availableNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int i = 0; i < 3; i++) {
            int randomIndex = Randoms.pickNumberInRange(0, availableNumbers.size() - 1);
            answer[i] = availableNumbers.remove(randomIndex);
        }
    }

    public int[] getAnswer() {
        return answer;
    }
}
