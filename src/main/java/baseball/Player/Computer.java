package baseball.Player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Player {
    @Override
    protected List<Integer> generateAnswer() {
        List<Integer> generatedAnswer = new ArrayList<>();
        while (generatedAnswer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedAnswer.contains(randomNumber)) {
                generatedAnswer.add(randomNumber);
            }
        }
        return generatedAnswer;
    }

    public boolean compareAnswer(List<Integer> userAnswer) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < ANSWER_SIZE; i++) {
            int compareResult = answer.indexOf(userAnswer.get(i));
            if (compareResult == i) {
                strikeCount++;
            } else if (compareResult != -1) {
                ballCount++;
            }
        }
        displayCompareResult(strikeCount, ballCount);
        return (strikeCount == ANSWER_SIZE);
    }

    private void displayCompareResult(int strikeCount, int ballCount) {
        String result = "";
        if (ballCount == 0 && strikeCount == 0) {
            result = "낫싱";
        } else {
            if (ballCount != 0) {
                result += ballCount + "볼 ";
            }
            if (strikeCount != 0) {
                result += strikeCount + "스트라이크";
            }
        }
        System.out.println(result);
    }
}
