package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private boolean on = true;
    private int strike = 0;
    private int ball = 0;

    private void toFalse() {
        on = false;
    }
    

    private void resetStrike() {
        this.strike = 0;
    }

    private void resetBall() {
        this.ball = 0;
    }

    private void upBall() {
        this.ball++;
    }

    private void upStrike() {
        this.strike++;
    }

    public void reStart() {
        resetStrike();
        resetBall();
        toFalse();
        List<Integer> cpuNewInput = new RandomNumber().getRandomNumbers();
        System.out.println("컴퓨터 숫자:" + cpuNewInput);
        System.out.print("숫자를 입력해주세요 : ");
        String userNewInput = readLine();
        new BaseballGame().start(cpuNewInput, userNewInput);
    }

    public void start(List<Integer> target, String input) {
        do {
            play(target, input);
        } while (on);
    }


    public void play(List<Integer> target, String input) {
        List<Integer> reTarget = new ArrayList<>(target);

        String message = "";

        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNum.add(Character.getNumericValue(input.charAt(i)));
        }

        for (int i = 0; i < 3; i++) {
            if (userNum.get(i).equals(target.get(i))) {
                upStrike();
                userNum.set(i, -1);
                target.set(i, -2);
            }
        }

        if (strike == 3) {
            ending();
            return;
        }
        countBall(target, userNum);
        System.out.println("ball:" + ball);
        if (strike == 0 && ball == 0) {
            message = "낫싱";
        } else {
            if (strike == 0) {
                message = ball + "볼";
            } else if (ball == 0) {
                message = strike + "스트라이크";
            } else {
                message = ball + "볼 " + strike + "스트라이크";
            }
        }
        resetStrike();
        resetBall();
        System.out.println(message);
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        play(reTarget, userInput);
    }

    public void ending() {
        System.out.println(
                strike + "스트라이크\n"
                        + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userDecide = readLine();
        if (userDecide.equals("1")) {
            reStart();
        } else if (userDecide.equals("2")) {
            toFalse();
        }
    }

    public void countBall(List<Integer> target, List<Integer> userNum) {
        for (int i = 0; i < 3; i++) {
            if (userNum.contains(target.get(i)) && !userNum.get(i).equals(target.get(i))) {
                upBall();
            }
        }
        System.out.println("countBall 함수의 ball:" + ball);
    }

}