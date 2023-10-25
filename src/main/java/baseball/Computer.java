package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answer;

    public Computer() {
        makeAnswer();
    }

    private void makeAnswer() {
        answer = new ArrayList<>();

        while (answer.size() < 3) {
            addRandomNumber();
        }
    }

    private void addRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }

    public BallCounter checkAnswer(List<Integer> inputBalls) {

        int strikeCount = countStrikes(inputBalls);
        int ballCount = countBalls(inputBalls);

        return new BallCounter(strikeCount, ballCount);
    }

    private int countStrikes(List<Integer> inputBalls) {
        int strikeCount = 0;

        for (int i = 0; i < inputBalls.size(); i++) {
            if (answer.get(i) == inputBalls.get(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int countBalls(List<Integer> inputBalls) {
        int ballCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            ballCount += countBall(i, inputBalls);
        }

        return ballCount;
    }

    private int countBall(int answerIndex, List<Integer> inputBalls) {
        int ballCount = 0;

        for (int i = 0; i < inputBalls.size(); i++) {
            ballCount += checkBallCount(answerIndex, i, inputBalls);
        }

        return ballCount;
    }

    private int checkBallCount(int answerIndex, int inputBallIndex, List<Integer> inputBalls) {
        if (answerIndex != inputBallIndex && answer.get(answerIndex) == inputBalls.get(inputBallIndex)) {
            return 1;
        }

        return 0;
    }
}
