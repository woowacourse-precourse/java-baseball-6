package controller;

import view.PlayGameInformationOutputView;
import view.PlayerNumberInputView;
import model.Computer;
import model.Player;
import model.Referee;

import java.util.Set;

public class BaseballGameController {
    PlayGameInformationOutputView playGameInformationOutputView = new PlayGameInformationOutputView();
    PlayerNumberInputView playerNumberInputView = new PlayerNumberInputView();
    Computer computer = new Computer();
    Player player = new Player();
    Referee referee = new Referee();

    public void gameProgress() {
        playGameInformationOutputView.printGameStart();
        computer.generateBalls();
        Set<Integer> computerBalls = computer.getComputerNumber();

        playerNumberInputView.guideInformation();
        player.generateBalls(playerNumberInputView.receiveNumber());
        Set<Integer> playerBalls = player.getPlayerNumber();

        String gameResult = referee.judgeValue(computerBalls, playerBalls);
        System.out.println(gameResult);
    }
}
