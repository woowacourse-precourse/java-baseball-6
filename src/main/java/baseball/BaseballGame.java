package baseball;

import java.util.ArrayList;
import java.util.List;

/*
* 게임을 관리하는 클래스
* */
public class BaseballGame {
    Answer answer;

    public Answer answerGenerate() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < 3) {
            int randomNumber = randomNumberGenerator.getRandoms();
            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
        answer = new Answer(answerNumbers);
        return answer;
    }

    public JudgedCounts judgeAnswer(Answer answer, int inputNumber) {
        int firstBall = inputNumber/100;
        int secondBall = inputNumber%100/10;
        int thirdBall = inputNumber%10;
        int[] balls = {firstBall,secondBall,thirdBall};
        List<Integer> answerList = answer.getAnswerNumbers();

        return judgeStrikeOrBall(answerList, balls);
    }

    private JudgedCounts judgeStrikeOrBall(List<Integer> answerList, int[] balls) {
        JudgedCounts judgedCounts = new JudgedCounts(0,0);
        for (int ball = 0; ball < answerList.size(); ball++) {
            if (answerList.get(ball) == balls[ball]) {
                judgedCounts.setStrike();
            } else if (answerList.contains(balls[ball])) {
                judgedCounts.setBall();
            }
        }
        return judgedCounts;
    }


}
