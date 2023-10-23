package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private final List<Integer> answerlist;

    public Answer() {
        answerlist = new ArrayList<>();
    }

    public void generate() {
        answerlist.clear();
        while (answerlist.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerlist.contains(randomNumber)) {
                answerlist.add(randomNumber);
            }
        }
    }

    public List<Integer> calculateStrikeAndBall(List<Integer> playerInputList) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (playerInputList.get(i).equals(answerlist.get(i))) {
                strike += 1;
            } else if (answerlist.contains(playerInputList.get(i))) {
                ball += 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(strike);
        list.add(ball);

        return list;
    }
}
