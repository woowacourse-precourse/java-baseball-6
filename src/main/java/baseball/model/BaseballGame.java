package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private int ball;
    private int strike;

    public BaseballGame(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(RangeConstant.START_INT, RangeConstant.END_INT);
    }

    public static BaseballGame checkScore(int randomNumber, int userNumber) {
        // 결과와 비교 로직
        int ball = 0;
        int strike = 0;

        ball = checkBall(randomNumber, userNumber);
        strike = checkStrike(randomNumber, userNumber);


        return new BaseballGame(ball, strike);
    }

    public static int checkBall(int randomNumber, int userNumber) {

        int count = 0;

        List<Integer> randomList = new ArrayList<>();
        List<Integer> userList = new ArrayList<>();

        while (randomNumber / 10 != 0) {
            randomList.add(randomNumber % 10);
            userList.add(userNumber % 10);

            randomNumber /= 10;
            userNumber /= 10;
        }
        randomList.add(randomNumber % 10);
        userList.add(userNumber % 10);

        for (int i = 0; i < randomList.size(); i++) {
            if(randomList.contains(userList.get(i)) && randomList.indexOf(userList.get(i)) != i)
                count++;
        }

        return count;
    }

    public static int checkStrike(int randomNumber, int userNumber) {

        int count = 0;

        while(randomNumber / 10 != 0) {
            if(randomNumber % 10 == userNumber % 10)
                count++;
            randomNumber /= 10;
            userNumber /= 10;
        }
        if(randomNumber % 10 == userNumber % 10)
            count++;

        return count;
    }

}
