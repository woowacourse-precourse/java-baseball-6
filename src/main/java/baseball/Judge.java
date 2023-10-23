package baseball;

import java.util.List;

public class Judge {
    private int strike = 0;
    private int ball = 0;
    List<Integer> answer;
    List<Integer> guess;

    public Judge(List<Integer> answer, List<Integer> guess) {
        this.answer = answer;
        this.guess = guess;
    }

    public void calcResult() {
        for (int i = 0; i < guess.size(); i++) {
            if (answer.contains(guess.get(i))) {
                if (answer.get(i).equals(guess.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
    }

    public void printResult() {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public boolean isCorrect() {
        return strike == 3;
    }
}
