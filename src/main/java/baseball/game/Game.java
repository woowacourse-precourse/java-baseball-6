package baseball.game;

import static constant.Constant.GAME_END_MESSAGE;
import static constant.Constant.INPUT_NUMBER_STRING;
import static constant.Constant.NOTHING_MESSAGE;
import static constant.Constant.RESTART_COMMAND;
import static constant.Constant.RESTART_MESSAGE;
import static constant.Constant.START_STRING;
import static constant.Constant.SUCCESS_MESSAGE;
import static constant.Constant.TERMINATE_COMMAND;
import static constant.ErrorMessage.ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import io.GameInitializer;
import io.Prompt;
import java.util.List;

public class Game {
    private final Prompt prompt;
    private final GameInitializer initializer;
    private final BaseballGameValueGenerator generator;
    private final Converter converter;

    public Game(Prompt prompt, BaseballGameValueGenerator generator) {
        this.prompt = prompt;
        this.initializer = new GameInitializer(prompt);
        this.generator = generator;
        this.converter = new Converter();
    }

    public void run() {
        try {
            this.prompt.println(START_STRING);
            boolean gameIsRunning = true;
            List<Integer> generatedNumbers = generator.generateThreeRandomNumbers();
            runGame(gameIsRunning, generatedNumbers);
        } catch (IllegalArgumentException e) {
            prompt.print(ERROR_MESSAGE);
            prompt.println(" " + e.getMessage());
            throw e;
        } finally {
            Console.close();
        }
    }

    private void runGame(boolean gameIsRunning, List<Integer> generatedNumbers) {
        while (gameIsRunning) {
            String userInputString = initializer.initNewGame(INPUT_NUMBER_STRING);
            List<Integer> userInputNumbers = converter.convertToInputNumbers(userInputString);
            InningResult inningResult = InningResult.countMatchesBetween(userInputNumbers, generatedNumbers);
            if (inningResult.noMatchesExists()) {
                prompt.print(NOTHING_MESSAGE);
            }
            if (inningResult.hasBalls()) {
                prompt.print(inningResult.getBallMessage());
            }
            if (inningResult.hasStrikes()) {
                prompt.print(inningResult.getStrikeMessage());
            }
            prompt.print("\n");
            if (inningResult.isThreeStrikes()) {
                prompt.println(SUCCESS_MESSAGE);
                String userInputStringWhenBeforeRestart = initializer.initNewGame(RESTART_MESSAGE, true);
                if (userInputStringWhenBeforeRestart.equals(RESTART_COMMAND)) {
                    generatedNumbers = generator.generateThreeRandomNumbers();
                } else if (userInputStringWhenBeforeRestart.equals(TERMINATE_COMMAND)) {
                    gameIsRunning = false;
                    prompt.println(GAME_END_MESSAGE);
                }
            }
        }
    }
}