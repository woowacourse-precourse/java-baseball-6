package baseball.domain;

import baseball.controller.ScoreHandler;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.ScoreViewer;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    String continueGame = "1";

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!continueGame.equals("2")) {
            Computer computer = new Computer();
            Player player = new Player();


            ScoreHandler scoreHandler = new ScoreHandler();

            while (!scoreHandler.hasThreeStrikes()) {
                player.getAttempt();
                scoreHandler.ScoreHandler(computer.getComputer(), player.getPlayer());
                ScoreViewer scoreViewer = new ScoreViewer(scoreHandler);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continueGame = Console.readLine();
        }
    }

}
