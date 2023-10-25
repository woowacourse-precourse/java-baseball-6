package controller;

import view.PlayGameInformationOutputView;
import view.PlayerNumberInputView;
import model.Computer;
import model.Player;
import model.Referee;
import util.PlayerGameRestartUtil;

import java.util.Set;

public class BaseballGameController {
    PlayGameInformationOutputView playGameInformationOutputView = new PlayGameInformationOutputView();
    PlayerNumberInputView playerNumberInputView = new PlayerNumberInputView();
    Computer computer = new Computer();
    Player player = new Player();
    Referee referee = new Referee();
    PlayerGameRestartUtil playerGameRestartUtil = new PlayerGameRestartUtil();

    private boolean isFirstRound = true;

    public void gameProgress() {
        while (true) {
            Set<Integer> computerBalls = null;
            Set<Integer> playerBalls = null;

            if (isFirstRound) {
                playGameInformationOutputView.printGameStart();
                computer.generateBalls();
                computerBalls = computer.getComputerNumber();
                isFirstRound = true;
            }

            playerNumberInputView.guideInformation();
            player.generateBalls(playerNumberInputView.receiveNumber());
            playerBalls = player.getPlayerNumber();

            String gameResult = referee.judgeValue(computerBalls, playerBalls);
            System.out.println(gameResult);

            playerGameRestartUtil.gameRestartQuestion();
        }
    }
}
