package baseball.game;

import baseball.variable.ComputerNumber;
import baseball.variable.PlayerNumber;
import baseball.print.PrintMessage;

import java.util.List;
import java.util.ArrayList;

public class GamePlaying {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    List<Integer> computerNumber = new ArrayList<>();
    List<Integer> playerNumber = new ArrayList<>();

    ComputerNumber cpu = new ComputerNumber();
    PlayerNumber player = new PlayerNumber();
    PrintMessage printer = new PrintMessage();

    public void playGame() {
        enterValue();

    }

    private void enterValue() {
        computerNumber = cpu.setComputerNumber(computerNumber);
        playerNumber = player.getPlayerNumber(playerNumber);
    }

    private int isSame(int i) {
        if (computerNumber.get(i) == playerNumber.get(i)) {
            return 1;
        }
        return 0;
    }


    private int findStrike(int strike) {
        for (int i = 0; i < 3; i++) {
            strike += isSame(i);
        }
        return strike;
    }

    private int findBall() {


    }

}
