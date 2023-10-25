package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballGameModel {
    public static final int BASEBALL_NUMBER_SIZE = 3;
    public static final int BASEBALL_NUMBER_MIN = 1;
    public static final int BASEBALL_NUMBER_MAX = 9;
    public static final String THREE_STRIKE = "3스트라이크";
    public static final String TWO_STRIKE = "2스트라이크";
    public static final String ONE_BALL_TWO_STRIKE = "1볼 2스트라이크";
    public static final String TWO_BALL_ONE_STRIKE = "2볼 1스트라이크";
    public static final String ONE_BALL_ONE_STRIKE = "1볼 1스트라이크";
    public static final String ONE_STRIKE = "1스트라이크";
    public static final String THREE_BALL = "3볼";
    public static final String TWO_BALL = "2볼";
    public static final String ONE_BALL = "1볼";
    public static final String NOTHING = "낫싱";

    public List<Integer> answerNums; // 컴퓨터가 가지고 있는 정답 숫자


    // 기본 생성자 선언.
    public BaseballGameModel() {
        this.answerNums = pickThreeNumbers(); // 컴퓨터가 가질 정답 숫자를 생성한다.
    }

    // 1. 컴퓨터가 가질 3개의 값을 초기화하는 메서드
    private List<Integer> pickThreeNumbers() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < BASEBALL_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBER_MIN, BASEBALL_NUMBER_MAX);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }
        return computerNums;
    }

    // 4. 입력한 수에 대한 결과를 볼, 스트라이크 개수로 출력하는 메서드
    public String calculateResult(String[] playerNums) {
        int strike = 0;
        int ball = 0;
        for (int index = 0; index < playerNums.length; index++) {
            Integer num = Integer.parseInt(playerNums[index]);
            if (isStrike(index, num)) {
                strike += 1;
            } else if (isBall(index, num)) {
                ball += 1;
            }
        }

        return createResult(strike, ball);
    }

    private static String createResult(int strike, int ball) {
        if (strike == 3) {
            return THREE_STRIKE;
        } else if (strike == 2 && ball == 0) {
            return TWO_STRIKE;
        } else if (strike == 2 && ball == 1) {
            return ONE_BALL_TWO_STRIKE;
        } else if (strike == 1 && ball == 2) {
            return TWO_BALL_ONE_STRIKE;
        } else if (strike == 1 && ball == 1) {
            return ONE_BALL_ONE_STRIKE;
        } else if (strike == 1 && ball == 0) {
            return ONE_STRIKE;
        } else if (strike == 0 && ball == 3) {
            return THREE_BALL;
        } else if (strike == 0 && ball == 2) {
            return TWO_BALL;
        } else if (strike == 0 && ball == 1) {
            return ONE_BALL;
        } else {
            return NOTHING;
        }
    }

    private boolean isBall(int index, Integer num) {
        return answerNums.contains(num) && !Objects.equals(answerNums.get(index), num);
    }

    private boolean isStrike(int index, Integer num) {
        return answerNums.contains(num) && Objects.equals(answerNums.get(index), num);
    }
}
