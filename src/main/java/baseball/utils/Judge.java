package baseball.utils;

import baseball.constants.Constants;
import baseball.constants.Messages;
import baseball.domain.Score;

import java.util.List;

public class Judge {
    public static String judgeScore(List<Integer> generatedAnswers, String userInput) {
        Score score = new Score();
        char[] charArray = userInput.toCharArray();
        for (int i = 0; i < Constants.CORRECT_ANSWER_LENGTH; i++) {
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

    public static boolean isCorrectAnswer(String expected, String actual) {
        if (actual.equals(expected)) {
            System.out.println(Messages.GAME_COMPLETE_MESSAGE);
            return true;
        }
        return false;
    }
}
