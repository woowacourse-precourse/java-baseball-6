package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private boolean on;
    private int strike;
    private int ball;
    private String message;

    BaseballGame() {
        this.on = true;
        this.strike = 0;
        this.ball = 0;
        this.message = "";
    }

    private void onToFalse() {
        this.on = false;
    }

    private void resetMessage() {
        this.message = "";
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

    private List<Integer> stringToIntegerList(String input) {
        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNum.add(Character.getNumericValue(input.charAt(i)));
        }
        return userNum;
    }

    private void reStart() {
        resetMessage();
        resetBall();
        resetStrike();
        onToFalse();
        List<Integer> cpuNewInput = new RandomNumber().getRandomNumbers();
        System.out.println("컴퓨터 숫자:" + cpuNewInput);
        System.out.print("숫자를 입력해주세요 : ");
        String userNewInput = readLine();
        start(cpuNewInput, userNewInput);
    }

    public void start(List<Integer> target, String input) {
        do {
            play(target, input);
        } while (this.on);
    }


    private void play(List<Integer> target, String input) {
        resetMessage();

        List<Integer> reTarget = new ArrayList<>(target);

        List<Integer> userNum = stringToIntegerList(input);

        countStrike(target, userNum);

        if (this.strike == 3) {
            ending();
            return;
        }
        countBall(target, userNum);
        System.out.println("ball:" + this.ball);
        calculateScore();
        resetStrike();
        resetBall();
        System.out.println(this.message);
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        play(reTarget, userInput);
    }

    private void calculateScore() {
        if (this.ball > 0) {
            this.message = this.ball + "볼";
        }
        if (this.strike > 0) {
            if (!this.message.isEmpty()) {
                this.message += " ";
            }
            this.message += this.strike + "스트라이크";
        }
        if (this.message.isEmpty()) {
            this.message = "낫싱";
        }
    }

    private void ending() {
        System.out.println(
                this.strike + "스트라이크\n"
                        + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userDecide = readLine();
        if (userDecide.equals("1")) {
            reStart();
        } else if (userDecide.equals("2")) {
            onToFalse();
        }
    }

    private void countStrike(List<Integer> target, List<Integer> userNum) {
        for (int i = 0; i < 3; i++) {
            if (userNum.get(i).equals(target.get(i))) {
                upStrike();
                userNum.set(i, -1);
                target.set(i, -2);
            }
        }
    }

    private void countBall(List<Integer> target, List<Integer> userNum) {
        for (int i = 0; i < 3; i++) {
            if (userNum.contains(target.get(i)) && !userNum.get(i).equals(target.get(i))) {
                upBall();
            }
        }
        System.out.println("countBall 함수의 ball:" + this.ball);
    }

}