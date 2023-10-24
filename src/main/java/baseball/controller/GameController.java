package baseball.controller;

import baseball.domain.GameSystem;
import baseball.domain.RandomNumber;
import baseball.domain.UserInput;
import baseball.service.GameService;
import baseball.service.RandomGeneratorService;
import baseball.service.UserInputService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final UserInputService userInputService;
    private final GameService gameService;
    private final RandomGeneratorService randomGeneratorService;
    static RandomNumber randNum;
    public GameController(UserInputService userInputService, GameService gameService,
            RandomGeneratorService randomGeneratorService) {
        this.userInputService = userInputService;
        this.gameService = gameService;
        this.randomGeneratorService = randomGeneratorService;
    }
    public GameState startBaseBallGame(GameState state){
        UserInput userInput = promptForUserInput(state);
        RandomNumber randomNumber = createNewRandomNumber(randNum, state);
        GameSystem gameSystem = playBaseBallGame(userInput, randomNumber);

        promptForStrike(gameSystem);
        promptForThreeStrike(gameSystem);
        promptForBall(gameSystem);
        promptForBallAndStrike(gameSystem);
        promptForNothing(gameSystem);

        if (gameSystem.getStrike() == 3) {
            return promptForContinue();
        }
        return GameState.CONTINUE;
    }
    private GameState promptForContinue(){
        InputView.continueGameMessage();
        UserInput userInput = userInputService.getUserInput();

        if (userInput.getUserInput().equals("1"))
            return GameState.RESTART;

        return GameState.END;

    }
    private UserInput promptForUserInput(GameState gameState){
        if (gameState == GameState.START)
            InputView.startGameMessage();
        InputView.requestInputMessage();
        UserInput userInput = userInputService.getUserInput();
        userInputService.checkValidation(userInput);
        return userInput;
    }
    private void promptForStrike(GameSystem gameSystem){
        if (gameSystem.getStrike() != 0 && gameSystem.getBallCount() == 0)
            OutputView.onlyStrike(gameSystem.getStrike());
    }
    private void promptForThreeStrike(GameSystem gameSystem){
        if(gameSystem.getStrike() == 3)
            OutputView.gameEnd();
    }
    private void promptForBall(GameSystem gameSystem){
        if (gameSystem.getStrike() == 0 && gameSystem.getBallCount() != 0)
            OutputView.onlyBall(gameSystem.getBallCount());
    }
    private void promptForBallAndStrike(GameSystem gameSystem){
        if (gameSystem.getStrike() !=0 && gameSystem.getBallCount() != 0)
            OutputView.ballAndStrike(gameSystem.getBallCount(), gameSystem.getStrike());
    }
    private void promptForNothing(GameSystem gameSystem){
        if (gameSystem.getStrike() ==0 && gameSystem.getBallCount() == 0){
            OutputView.nothing();
        }
    }
    private RandomNumber createNewRandomNumber(RandomNumber randomNumber, GameState gameState){
        if (gameState != GameState.CONTINUE)
            return randNum = randomGeneratorService.createRandomNumber();
        return randomNumber;
    }
    private GameSystem playBaseBallGame(UserInput userInput, RandomNumber randomNumber){
        return gameService.playGame(userInput, randomNumber);
    }

}
