package baseball.domain;

import baseball.utils.Setting;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Answer {

    private List<Integer> answerNumber;

    private BallCount ballCount;

    public Answer() {
        answerNumber = new ArrayList<>();
        ballCount = new BallCount();
    }

    public void setAnswerNumber() {

        for (int i = 0; i < Setting.NUM_LENGTH; i++) {
            int randomNumber = pickNumberInRange();

            // Check Duplicate
            while(answerNumber.contains(randomNumber))
                randomNumber = pickNumberInRange();

            answerNumber.add(randomNumber);
        }

        System.out.println("answerNumber = " + answerNumber);
    }

    public int pickNumberInRange() {
        return Randoms.pickNumberInRange(Setting.startRange, Setting.endRange);
    }

    public Boolean isCorrect(String input) {

        int strike = scoreAnswer(input);

        if(strike == Setting.NUM_LENGTH)  // 정답을 맞췄을 경우!
            return true;

        return false;
    }

    public int scoreAnswer(String input) {

        int ball = 0;
        int strike = 0;

        // Scoring Logic
        for (int i = 0; i < Setting.NUM_LENGTH; i++) {
            int num = Integer.parseInt(input.substring(i, i + 1));

            if (answerNumber.contains(num) && answerNumber.get(i) == num)
                strike += 1;
            else if (answerNumber.contains(num))
                ball += 1;
        }

        ballCount.setBallCount(ball, strike);
        return strike;  // Return a strike to determine the correct answer
    }
}
