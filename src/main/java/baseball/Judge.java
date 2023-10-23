package baseball;

import java.util.List;

public class Judge {
    private int strike = 0;
    private int ball = 0;
    List<Integer> computer;
    List<Integer> userInputList;

    public Judge(List<Integer> computer, List<Integer> userInputList) {
        this.computer = computer;
        this.userInputList = userInputList;
    }

    public void calcResult() {
        for (int i = 0; i < userInputList.size(); i++) {
            if (computer.contains(userInputList.get(i))) {
                if (computer.get(i).equals(userInputList.get(i))) {
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
