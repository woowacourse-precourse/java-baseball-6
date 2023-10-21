package controller;

import Util.ComputerNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.BaseballGameView;

public class BaseballGameController {
    private final BaseballGameView baseballGameView = new BaseballGameView();
    private int isContinue = 1;

    public void repeatBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isContinue == 1) {
            doBaseballGame();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isContinue = baseballGameView.isContinue();
        }
    }

    private void doBaseballGame() {
        List<Integer> computer = ComputerNumberGenerator.generate();

        List<Integer> userNumbers = new ArrayList<>();

        while (!computer.equals(userNumbers)) {
            userNumbers = baseballGameView.getUserNumberList();

            int strikeCount = 0;
            int includedNumberCount = 0;

            for (int i = 0; i < 3; i++) {
                if (computer.get(i).equals(userNumbers.get(i))) {
                    strikeCount ++;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (computer.contains(userNumbers.get(i))) {
                    includedNumberCount ++;
                }
            }

            int ballCount = includedNumberCount - strikeCount;

            if (includedNumberCount == 0) {
                System.out.println("낫싱");
            } else if (strikeCount == 0) {
                System.out.println(ballCount + "볼");
            } else if (strikeCount == includedNumberCount) {
                System.out.println(strikeCount + "스트라이크");
            } else if (strikeCount > 0) {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            }
        }
    }

}
