package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    public void play() {
        OutputView.printGameStartMessage();
        run();
    }

    private void run() {
        process();
        askForContinue();
    }

    private void process() {
        final Computer computer = ComputerGenerator.generate();

        while (true) {
            final PlayResult playResult = play(computer);

            if (playResult.isAllStrike()) {
                break;
            }
        }
    }

    private PlayResult play(final Computer computer) {
        final Player player = createPlayer();
        final PlayResult playResult = player.play(computer);
        OutputView.printResult(playResult);
        return playResult;
    }

    private Player createPlayer() {
        return new Player(InputView.readNumbers());
    }

    private void askForContinue() {
        final GameOption option = createGameOption();

        if (option.isContinue()) {
            run();
        }
    }

    private GameOption createGameOption() {
        return GameOption.of(InputView.readOptionNumber());
    }
}
