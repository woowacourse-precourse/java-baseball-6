package baseball.game;

import static constant.Constant.START_STRING;
import static constant.Constant.SUCCESS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import io.GameUserInterface;
import java.util.List;

public class Game {
    private final GameUserInterface ui;
    private final BaseballGameValueGenerator generator;
    private final Converter converter;

    private final ResultHandler resultHandler;

    public Game(GameUserInterface ui, BaseballGameValueGenerator generator, Converter converter,
                ResultHandler resultHandler) {
        this.ui = ui;
        this.generator = generator;
        this.converter = converter;
        this.resultHandler = resultHandler;
    }

    public void run() {
        try {
            ui.println(START_STRING);
            runGame();
        } finally {
            Console.close();
        }
    }

    private void runGame() {
        BaseballGameStatus gameStatus = BaseballGameStatus.newGame(generator.generateThreeRandomNumbers());
        while (gameStatus.gameIsRunning()) {
            List<Integer> userInputNumbers = ui.printEnterNumberMessageAndReceiveInput();
            InningResult inningResult = InningResult.countMatchesBetween(userInputNumbers,
                    gameStatus.generatedNumbers());
            resultHandler.handleInningResult(inningResult);
            if (inningResult.isThreeStrikes()) {
                ui.println(SUCCESS_MESSAGE);
                String userInput = ui.printRestartMessageAndReceiveInput();
                gameStatus = resultHandler.handleThreeStrikes(userInput);
            }
        }
    }
}