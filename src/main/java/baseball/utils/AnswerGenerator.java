package baseball.utils;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {
    public static List<Integer> generateAnswers() {
        List<Integer> generatedAnswers = new ArrayList<>();

        for (int i = 0; i < Constants.ANS_LEN; i++) {
            int candidateNum;
            do {
                candidateNum = Randoms.pickNumberInRange(Constants.MIN_GUESS_NUMBER, Constants.MAX_GUESS_NUMBER);
            } while (checkDuplicateNum(generatedAnswers, candidateNum));
            generatedAnswers.add(candidateNum);
        }

        return generatedAnswers;
    }

    private static boolean checkDuplicateNum(List<Integer> generatedAnswers, int candidateNum) {
        if (generatedAnswers.contains(candidateNum)) {
            return true;
        }
        return false;
    }
}
