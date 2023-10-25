package baseball.utils;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AnswerGenerator {
    public static List<Integer> generateAnswers() {
        // LinkedHashSet을 활용하여 중복 제거
        Set<Integer> generatedAnswers = new LinkedHashSet<>();

        while (generatedAnswers.size() < Constants.CORRECT_ANSWER_LENGTH) {
            int candidateNum = Randoms.pickNumberInRange(Constants.MIN_GUESS_NUMBER, Constants.MAX_GUESS_NUMBER);
            generatedAnswers.add(candidateNum);
        }
        return new ArrayList<>(generatedAnswers);
    }
}
