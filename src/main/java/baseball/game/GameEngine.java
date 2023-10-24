package baseball.game;

import static baseball.game.menu.GameMenu.FINISH;

import baseball.game.computer.Computer;
import baseball.game.computer.GameResult;
import baseball.game.generator.TargetGenerator;
import baseball.game.io.ConsoleFacade;
import baseball.game.menu.GameMenu;
import java.util.List;
import java.util.Objects;

public class GameEngine {

    private final ConsoleFacade consoleFacade;
    private final Computer computer;
    private final TargetGenerator targetGenerator;

    public GameEngine() {
        this.consoleFacade = new ConsoleFacade();
        this.computer = new Computer();
        this.targetGenerator = new TargetGenerator();
    }

    public void playGame() {
        consoleFacade.printGameStart();

        while (true) {
            final List<Integer> targetNumbers = targetGenerator.generateTargetNumbers();

            playInning(targetNumbers);

            consoleFacade.printEndGame();

            final String menu = consoleFacade.getMenu();
            final GameMenu gameMenu = GameMenu.ordinalOf(menu);
            if (Objects.equals(gameMenu, FINISH)) {
                break;
            }
        }
    }

    private void playInning(final List<Integer> targetNumbers) {
        while (true) {
            List<Integer> numbers = consoleFacade.getNumbers();

            final GameResult result = computer.compute(targetNumbers, numbers);

            consoleFacade.printGameScore(result.getGameScore());
            if (result.isInningEnd()) {
                break;
            }
        }
    }
}
