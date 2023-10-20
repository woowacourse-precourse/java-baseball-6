package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView.printGameStartMessage();
        run();
    }

    private static void run() {
        process();
        askForContinue();
    }

    private static void process() {
        Computer computer = ComputerGenerator.generate();

        while (true) {
            PlayResult playResult = play(computer);
            OutputView.printResult(playResult);

            if (playResult.isAllStrike()) {
                break;
            }
        }
    }

    private static PlayResult play(final Computer computer) {
        final Player player = new Player(InputView.readNumbers());
        return player.play(computer);
    }

    private static void askForContinue() {
        final GameOption option = createGameOption();

        if (option.isContinue()) {
            run();
        }
    }

    private static GameOption createGameOption() {
        return GameOption.of(InputView.readOptionNumber());
    }
}
