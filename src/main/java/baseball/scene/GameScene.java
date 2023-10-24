package baseball.scene;

import baseball.game.BallAndStrike;
import baseball.game.BaseBallNumberGroup;
import baseball.game.BaseBallResult;
import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import baseball.input.GameSceneInput;
import baseball.output.BaseBallResultOutput;
import baseball.output.GameSceneOutput;
import baseball.output.rule.RuleConstants;
import baseball.util.RandomNumberGenerator;
import java.util.List;
import java.util.stream.Stream;

public class GameScene implements Scene {
    private final GameStateManager gameStateManager;
    private final GameSceneInput input;
    private final GameSceneOutput output;

    public GameScene(
            final GameStateManager gameStateManager,
            final GameSceneInput input,
            final GameSceneOutput output
    ) {
        this.gameStateManager = gameStateManager;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        final List<Integer> randomNumberList = RandomNumberGenerator.generate();
        final BaseBallNumberGroup computer = new BaseBallNumberGroup(randomNumberList);

        while (gameStateManager.isInGame()) {
            runWhenGameStateInGame(computer);
        }
    }

    private void runWhenGameStateInGame(final BaseBallNumberGroup computer) {
        final BaseBallNumberGroup user = getUserBaseBallNumberGroup();
        final BaseBallResult baseBallResult = new BaseBallResult(computer, user);
        printBaseBallResult(baseBallResult);
        gameOverWhenAllStrike(baseBallResult);
    }

    private BaseBallNumberGroup getUserBaseBallNumberGroup() {
        output.printInputMessage();
        final String userInput = input.getUserInput();
        final BaseBallNumberGroup userBaseBallNumberGroup = new BaseBallNumberGroup(
                getNumberListFromUserInput(userInput)
        );
        return userBaseBallNumberGroup;
    }

    private void printBaseBallResult(final BaseBallResult baseBallResult) {
        final BallAndStrike ballAndStrike = baseBallResult.getBallAndStrike();
        final BaseBallResultOutput baseBallResultOutput = new BaseBallResultOutput(
                RuleConstants.getStandardRules(ballAndStrike)
        );
        baseBallResultOutput.printAllRules();
    }

    private List<Integer> getNumberListFromUserInput(final String userInput) {
        final String[] userInputSplitByEveryCharacter = userInput.split("");
        final List<Integer> numberList = Stream.of(userInputSplitByEveryCharacter)
                .map(Integer::parseInt)
                .toList();
        return numberList;
    }

    private void gameOverWhenAllStrike(final BaseBallResult baseBallResult) {
        if (baseBallResult.isAllStrike()) {
            gameStateManager.update(GameState.GAME_OVER);
        }
    }
}
