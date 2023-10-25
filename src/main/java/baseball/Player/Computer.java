package baseball.Player;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer extends Player {
    private static final int STRIKE_COUNT = 0;
    private static final int BALL_COUNT = 1;
    private static final int NOTHING_COUNT = 2;

    @Override
    protected List<Integer> generateAnswer() {
        List<Integer> generatedAnswer = new ArrayList<>();
        while (generatedAnswer.size() < ANSWER_SIZE) {
            addUniqueNumber(generatedAnswer);
        }
        return generatedAnswer;
    }

    private static void addUniqueNumber(List<Integer> generatedAnswer) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!generatedAnswer.contains(randomNumber)) {
            generatedAnswer.add(randomNumber);
        }
    }

    public boolean compareAnswer(List<Integer> userAnswer) {
        int[] pitchCount = new int[3]; // 0: strike, 1: ball, 2: nothing
        for (int i = 0; i < ANSWER_SIZE; i++) {
            int result = compare(userAnswer, pitchCount, i);
            pitchCount[result]++;
        }
        System.out.println(getCompareResult(pitchCount));
        return (pitchCount[STRIKE_COUNT] == ANSWER_SIZE);
    }

    private int compare(List<Integer> userAnswer, int[] pitchCount, int i) {
        int compareResult = answer.indexOf(userAnswer.get(i));
        if (compareResult == i) {
            return STRIKE_COUNT;
        }
        if (compareResult != -1) {
            return BALL_COUNT;
        }
        return NOTHING_COUNT;
    }

    private String getCompareResult(int[] pitchCount) {
        if (pitchCount[STRIKE_COUNT] == 0 && pitchCount[BALL_COUNT] == 0) {
            return "낫싱";
        }
        String result = "";
        if (pitchCount[BALL_COUNT] != 0) {
            result += pitchCount[BALL_COUNT] + "볼 ";
        }
        if (pitchCount[STRIKE_COUNT] != 0) {
            result += pitchCount[STRIKE_COUNT] + "스트라이크";
        }
        return result;
    }
}
