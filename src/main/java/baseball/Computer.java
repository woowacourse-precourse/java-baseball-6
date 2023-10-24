package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answer = new ArrayList<>();

    Computer() {

    }

    public void makeAnswer() {
        answer.clear();

        while (answer.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(num)) {
                answer.add(num);
            }
        }
    }

    public boolean checkAnswer(String input) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            int num = input.charAt(i) - '0';

            if (answer.contains(num)) {
                if (answer.get(i) == num) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }

        printResult(ballCount, strikeCount);

        if (strikeCount == 3) {
            return true;
        }

        return false;
    }

    private void printResult(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }
}
