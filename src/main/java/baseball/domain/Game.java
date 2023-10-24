package baseball.domain;

import baseball.util.InputValidator;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer;
    private final Player player;
    private final Judge judge;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
        this.judge = new Judge();
    }

    public boolean start() {

        boolean isFinished = false;

        while (!isFinished) {
            GameView.printUserInputMessage();
            player.enterNumber();
            isFinished = judge.judgmentFinish(player, computer);
        }

        return checkRestart();
    }

    private boolean checkRestart() {
        boolean isRestarted = true;

        GameView.printRestartMessage();
        String input = Console.readLine();

        InputValidator.checkRestartInputFormat(input);

        if (input.equals("2")) {
            isRestarted = false;
        }

        return isRestarted;
    }
}
