package baseball.game.model;

import baseball.game.controller.dto.NumberListDto;
import baseball.game.model.dto.RoundResultDto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤 숫자 생성과 라운드 결과를 계산하는 클래스
 */
public class GameModel {

    public NumberListDto generateRandomAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return new NumberListDto(answer);
    }

    public RoundResultDto calculateRoundResult(NumberListDto answer, NumberListDto guess) {
        int ballCount = 0;
        int strikeCount = 0;

        List<Integer> answerList = answer.getNumberList();
        List<Integer> guessList = guess.getNumberList();

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

        return new RoundResultDto(ballCount, strikeCount);
    }
}
