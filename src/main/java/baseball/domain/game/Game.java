package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.player.Player;

import java.util.List;
import java.util.Objects;

public class Game {
    private final Computer computer;
    private Player player;
    private PlayResult playResult;

    public Game(Computer computer, Player player) {
        playResult = new PlayResult();
        this.computer = computer;
        this.player = player;
    }

    public String getPlayerResult() {
        playResult.clearResult();
        PlayResult result = compareComputerNumbersAndPlayerNumbers();
        return result.returnResult();
    }



    public PlayResult compareComputerNumbersAndPlayerNumbers() {
        List<Integer> computerNumbers = computer.getComputerThreeNumbers();
        List<Integer> playerNumbers = player.getPlayerThreeNumbers();

        for(int computerIdx = 0; computerIdx < computerNumbers.size(); computerIdx++) {
            for(int playerIdx = 0; playerIdx < playerNumbers.size(); playerIdx++) {
                Integer computerNumber = computerNumbers.get(computerIdx);
                Integer playerNumber = playerNumbers.get(playerIdx);

                if(Objects.equals(computerNumber, playerNumber) && computerIdx == playerIdx) {
                    playResult.plusStrikeCnt();
                    continue;
                }
                if(Objects.equals(computerNumber, playerNumber)) {
                    playResult.plusBallCnt();
                }
            }
        }
        return playResult;
    }
}
