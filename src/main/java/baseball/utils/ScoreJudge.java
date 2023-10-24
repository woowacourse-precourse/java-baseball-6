package baseball.utils;

import baseball.constants.Constants;
import baseball.domain.Score;

import java.util.List;

public class ScoreJudge {
    public static String judgeScore(List<Integer> generatedAnswers, String userInput) {
        Score score = new Score();
        char[] charArray = userInput.toCharArray();
        for (int i = 0; i < Constants.ANS_LEN; i++) {
            int curAnsNum = generatedAnswers.get(i);
            int curUserNum = charArray[i] - '0';

            if (curAnsNum == curUserNum) {
                score.addStrikeCount();
            }
            if (curAnsNum != curUserNum && generatedAnswers.contains(curUserNum)) {
                score.addBallCount();
            }
        }
        return score.printScore();
    }
}
