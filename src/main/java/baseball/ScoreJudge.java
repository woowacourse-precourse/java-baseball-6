package baseball;

import java.util.List;

public class ScoreJudge {
    public static String judgeScore(List<Integer> generatedAnswers, String userInput) {
        int ballCnt = 0;
        int strikeCnt = 0;
        String result = "";

        char[] charArray = userInput.toCharArray();
        for (int i = 0; i < Constants.ANS_LEN; i++) {
            int curAnsNum = generatedAnswers.get(i);
            int curUserNum = charArray[i] - '0';

            if (curAnsNum == curUserNum) {
                strikeCnt++;
            }
            if (curAnsNum != curUserNum && generatedAnswers.contains(curUserNum)) {
                ballCnt++;
            }
        }

        if (ballCnt != 0) {
            result += ballCnt + "볼";
        }
        if (ballCnt != 0 && strikeCnt != 0) {
            result += " ";
        }
        if (strikeCnt != 0) {
            result += strikeCnt + "스트라이크";
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            result += "낫싱";
        }

        return result;
    }
}
