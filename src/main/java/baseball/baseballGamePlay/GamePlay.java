package baseball.baseballGamePlay;


import static baseball.print.InputMessage.getGameStatusInput;
import static baseball.print.OutputMessage.printMessageStartBaseballGame;

import baseball.baseballNumber.RamdomNumber;
import java.util.List;

public class GamePlay {
    private final RamdomNumber ramdomNumber = new RamdomNumber();
    private final GameHint gameHint = new GameHint();
    private final Integer THREE_STRIKE = 3;
    private final int GAME_COUNT = 2;

    public void baseballGamePlay() {
        printMessageStartBaseballGame();
        Integer gameCount = 0;
        while (gameCount < GAME_COUNT) {
            List<Integer> baseballNumber = ramdomNumber.ramdomBaseballNumber();
            if (gameHint.baseballGameHint(baseballNumber) == THREE_STRIKE) {
                gameCount = getGameStatusInput();
            }
        }
    }

}
