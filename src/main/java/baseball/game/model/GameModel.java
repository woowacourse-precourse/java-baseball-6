package baseball.game.model;

import baseball.game.model.dto.RoundResult;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    public List<Integer> generateRandomAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public RoundResult calculateRoundResult(List<Integer> answerList, List<Integer> guessList) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Integer guessNum = guessList.get(i);
                Integer answerNum = answerList.get(j);

                if (!guessNum.equals(answerNum)) {
                    continue;
                }

                if (i == j) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }

        return new RoundResult(ballCount, strikeCount);
    }
}
