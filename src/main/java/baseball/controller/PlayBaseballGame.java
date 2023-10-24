package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.ComputerService;
import baseball.service.Play;
import baseball.service.PlayerService;

public class PlayBaseballGame {
    private final ComputerService computer = new ComputerService();
    private final PlayerService player = new PlayerService();
    private final Play play = new Play();
    private final Computer computerNumber = new Computer();
    private final Player playerNumber = new Player();

    public void play() {
        computerNumber.setComputerNumber(computer.createRandomNumber());
        boolean isReplay = true;
        while (isReplay) {
            playerNumber.setPlayerNumber(player.inputPlayerNumber());
            play.getHint(playerNumber, computerNumber);
            if(playerNumber.getStrikeCount() == 3) {
                isReplay = endGame();
            }
        }
    }

    private boolean endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return player.inputOneOrTwo();
    }
}

