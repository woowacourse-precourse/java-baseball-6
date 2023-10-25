package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Compare {

    private static int strike = 0;
    private static int ball = 0;

    //입력 받은 수와 컴퓨터 수 비교
    public static void compareNum(List<Integer> computerNum, List<Integer> userNum) {

        dataInit(); //초기화

        for (int i = 0; i < 3; i++) {
            calculateStrike(computerNum.get(i), userNum.get(i)); //strike 계산
            calculateBall(computerNum, userNum.get(i)); //ball 계산
        }

        removeDuplicateBall(); //중복된 ball 제거
    }

    //숫자와 위치가 모두 같으면 strike++
    public static void calculateStrike(int computerNum, int userNum) {

        if (computerNum == userNum) {
            strike++;
        }

    }

    //ball 계산
    public static void calculateBall(List<Integer> computerNum, int userNum) {

        //숫자를 포함하면 ball 증가
        if (computerNum.contains(userNum)) {
            ball++;
        }

    }

    //중복된 ball 제거
    public static void removeDuplicateBall() {
        ball = ball - strike;
    }

    //스트라이크, 볼 초기화
    public static void dataInit() {
        strike = 0;
        ball = 0;
    }

    //strike 반환
    public static int getStrike() {
        return strike;
    }

    //ball 반환
    public static int getBall() {
        return ball;
    }
}
