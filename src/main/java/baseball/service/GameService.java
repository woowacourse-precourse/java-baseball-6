package baseball.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.constant.Game;
import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.view.GameOutput;

public class GameService {

    public static void startGame() {
        GameOutput.startBaseballGame();
        settingGame();
        playGame();
    }

    private static void playGame() {

        while (!Computer.isStrike(Player.playerNumbers)) {
            Hint.compareNumber(Computer.computerNumber, Player.playerNumbers);
            inputPlayerNumber();
        }
        endGame();
    }

    private static void endGame() {
        GameOutput.findCorrectAnswer();
        inquiryRetryGame();
    }

    private static void settingGame() {
        Computer.setComputerNumber();
        inputPlayerNumber();
    }

    private static void inputPlayerNumber() {
        GameOutput.progressInputNumber();
        Player.setPlayerNumber(readLine());
    }

    private static void inquiryRetryGame() {
        GameOutput.endBaseballGame();
        Computer.setRetryOrFinishFlag(readLine());

        switch (Computer.restartOrFinishFlag) {
            case Game.RETRY -> retryGame();
            case Game.FINISH -> GameOutput.exitBaseballGame();
        }
    }

    private static void retryGame() {
        settingGame();
        playGame();
    }

}
