package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static ArrayList<Integer> answerNumber = new ArrayList<>();

    private void returnResult(int strike, int ball) {
        String strikeResult = "";
        String ballResult = "";
        if (strike > 0) {
            strikeResult = strike + "스트라이크";
        }
        if (ball > 0) {
            ballResult = ball + "볼";
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ballResult + strikeResult);
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            Player.restartOrEnd();
        } else {
            Player.input();
        }
    }

    public static void checkScore(ArrayList<Integer> inputNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answerNumber.size(); i++) {
            Integer num = answerNumber.get(i);
            if (inputNumber.contains(num)) {
                if (inputNumber.indexOf(num) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        Computer c = new Computer();
        c.returnResult(strike, ball);
    }

    public static void createRandomNumber() {
        answerNumber.clear();
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        for(Integer i : list){
            answerNumber.add(i);
        }
    }
}