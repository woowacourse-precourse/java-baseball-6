package baseball.utils;

import baseball.constants.Constants;
import baseball.constants.Messages;
import baseball.domain.Score;
import java.util.List;

public class Judge {
    public static String judgeScore(List<Integer> generatedAnswers, String userInput) {
        Score score = new Score();

        for (int i = 0; i < Constants.CORRECT_ANSWER_LENGTH; i++) {
            int curAnsNum = generatedAnswers.get(i);
            int curUserNum = Character.getNumericValue(userInput.charAt(i));

            assessStrike(score, curAnsNum, curUserNum);
            assessBall(score, curAnsNum, curUserNum, generatedAnswers);
        }
        return score.toString();
    }

    private static void assessStrike(Score score, int curAnsNum, int curUserNum) {
        if (curAnsNum == curUserNum) {
            score.addStrikeCount();
        }
    }

    private static void assessBall(Score score, int curAnsNum, int curUserNum, List<Integer> generatedAnswers) {
        if (curAnsNum != curUserNum && generatedAnswers.contains(curUserNum)) {
            score.addBallCount();
        }
    }

    public static boolean isCorrectAnswer(String expected, String actual) {
        if (actual.equals(expected)) {
            System.out.println(Messages.GAME_COMPLETE_MESSAGE);
            return true;
        }
        return false;
    }
}
