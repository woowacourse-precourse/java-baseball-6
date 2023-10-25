package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int strikeCount;
    private int ballCount;
    private static List<Integer> answer = new ArrayList<>();

    Computer() {}

    public void setAnswer() {
        answer.clear();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public boolean checkAnswer(String input) {
        strikeCount = 0;
        ballCount = 0;

        checkStrike(input);
        checkBall(input);

        resultGame(ballCount, strikeCount);

        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    private void checkStrike(String input) {
        for (int i = 0; i < 3; i++) {
            if ((answer.get(i)).equals(input.charAt(i) - '0'))
                this.strikeCount++;
        }
    }

    private void checkBall(String input) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && (answer.get(j)).equals(input.charAt(i) - '0')) {
                    this.ballCount++;
                }
            }
        }
    }

    private void resultGame(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else {
            if (ballCount > 0)
                System.out.print(ballCount + "볼 ");
            if (strikeCount > 0)
                System.out.print(strikeCount + "스트라이크");
            System.out.println();
        }
    }
}
