package controller;

import Util.ComputerNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import view.BaseballGameView;

public class BaseballGameController {
    private final BaseballGameView baseballGameView = new BaseballGameView();

    public void doBaseballGame() {
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
