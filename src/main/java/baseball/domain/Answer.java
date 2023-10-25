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

    public void setAnswerNumber() {  // 정답 세팅 메서드

        for (int i = 0; i < Setting.NUM_LENGTH; i++) {
            int randomNumber = pickNumberInRange();

            // 서로 다른 3자리 숫자를 정답으로 구성하기 위한 반복문 사용
            while(answerNumber.contains(randomNumber))
                randomNumber = pickNumberInRange();

            answerNumber.add(randomNumber);
        }
    }

    public Boolean isCorrect(String input) {  // 정답 여부 반환 메서드

        int strike = scoreAnswer(input);

        if(strike == Setting.NUM_LENGTH)
            return true;  // 정답인 경우

        return false;  // 오답인 경우
    }

    public int scoreAnswer(String input) {  // 볼카운트 세팅 메서드

        int ball = 0;
        int strike = 0;

        // 볼카운트 채점 로직
        for (int i = 0; i < Setting.NUM_LENGTH; i++) {
            int num = Integer.parseInt(input.substring(i, i + 1));

            if (answerNumber.contains(num) && answerNumber.get(i) == num)
                strike += 1;
            else if (answerNumber.contains(num))
                ball += 1;
        }

        ballCount.setBallCount(ball, strike);
        return strike;  // 정답 여부를 알기 위한 스트라이크 반환
    }

    public int pickNumberInRange() {  // 난수 반환 메서드
        return Randoms.pickNumberInRange(Setting.startRange, Setting.endRange);
    }
}
