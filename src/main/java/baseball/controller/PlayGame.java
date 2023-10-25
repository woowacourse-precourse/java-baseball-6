package baseball.controller;

import baseball.model.ComputerRandomInt;
import baseball.view.InputView;
import baseball.view.OutputView;

public class PlayGame {
    Compare compare = new Compare();

    public void Game() {
        OutputView.printStart();

        while (true) {
            String computer = ComputerRandomInt.randomNum();
            System.out.println(computer);

            boolean isAllStrike = false;

            while (!isAllStrike) {
                String user = InputView.inputUserNum();

                compare.compareBall(computer, user);
                int strikeCount = compare.compareStrike(computer, user);

                OutputView.printHint(compare.hintMessage());

                if (strikeCount == 3) {
                    OutputView.printEnd();
                    isAllStrike = true;
                }
            }

            String userGameChoice = InputView.inputUserGame();

            if (userGameChoice.equals("1")) {
                continue;
            } else if (userGameChoice.equals("2")) {
                System.out.println("게임 종료");
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}