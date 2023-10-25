package baseball.controller;

import baseball.console.InputConsole;
import baseball.console.MainController;
import baseball.domain.player.ComputerPlayer;
import baseball.domain.player.UserPlayer;
import baseball.domain.rules.Rules;
import com.sun.tools.javac.Main;

public class GameController {
    // getReplaymanual() 이거 true면 다시 시작
    private static UserPlayer userPlayer;
    private ComputerPlayer computerPlayer;
    private MainController mainController;
    private Rules rules;

    public void start() {
        boolean restart = true;
        while (restart) {
            this.userPlayer = new UserPlayer();
            this.computerPlayer = new ComputerPlayer();
            MainController.printStartingGame();
            computerPlayer.setComputerNumber();
            play();
            mainController.printFinish();
            restart = mainController.getReplaymanual();
        }

    }

    public static void play() {
        boolean isGameOver = false;

        while (!isGameOver) {
            int[] score;
            userPlayer.setUserNumber();
            InputConsole.userNumSetting(userPlayer.getUserNumber());
            score = Rules.userScore(MainController.userNumGetting(), MainController.computerNumSetting()); // 메인 컨트롤러에 인풋콘솔 정리하고 re
            MainController.printResult(score);
            isGameOver = Rules.isGameOver(score);
        }
    }
}
