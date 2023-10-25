package baseball.games.numberbaseball.core;

import baseball.GamingConsole;
import baseball.games.numberbaseball.enums.PlayerOption;
import baseball.games.numberbaseball.util.BaseballPrinter;
import baseball.games.numberbaseball.util.NumberGenerator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballExecutor implements GamingConsole {
    private final NumberGenerator numberGenerator;

    public BaseballExecutor() {
        this.numberGenerator = new NumberGenerator();
    }

    @Override
    public void createNewGame() {
        Baseball baseball = new Baseball();
        baseball.playGame();
        if (isGameRestart()) {
            createNewGame();
        }
    }

    private boolean isGameRestart() {
        BaseballPrinter.printOptionInputMessage();
        return PlayerOption.RESTART == numberGenerator.createValidatedOption(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}
