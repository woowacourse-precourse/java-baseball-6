package baseball.controller;

import baseball.constant.NumberConstant;
import baseball.dto.GameStateDto;
import baseball.service.BaseballService;
import baseball.service.ComputerNumberGenerator;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private static final String RESTART = "1";
    private static String computerNumber;
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator = new Validator();


    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void playball() {
        computerNumber = getComputerNumber();
        try {
            logicStart();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void logicStart() {
        GameStateDto gamestate;
        do {
            outputView.printInputInitMessage();
            String userNumber = getUserNumber();
            BaseballService baseballService = new BaseballService(userNumber, computerNumber);
            gamestate = baseballService.calculate();
            outputResult(gamestate);
        } while (isGameReStart(gamestate));
    }

    private boolean isGameReStart(GameStateDto gameState) {
        if (gameState.isEndGame()) {
            checkRestart(gameState);
            checkComputerNumberChange(gameState);
            return gameState.isRestart();
        }
        return true;
    }

    private void checkComputerNumberChange(GameStateDto gameState) {
        if (gameState.isRestart()) {
            computerNumber = changeComputerNumber();
        }
    }

    private String changeComputerNumber() {
        String computerNumber;
        computerNumber = getComputerNumber();
        return computerNumber;
    }

    private void checkRestart(GameStateDto gamestate) {
        String restartNumber = inputView.readRestart();
        validator.validateRestart(restartNumber);
        if (restartNumber.equals(RESTART)) {
            gamestate.activateRestart();
        }
    }


    private void outputResult(GameStateDto gamestate) {
        int strike = gamestate.getStrike();
        int ball = gamestate.getBall();
        if (strike == NumberConstant.THREE_STRIKE.getNumber()) {
            threeStrikeProcess(gamestate, strike);
        } else if (strike > 0 && ball > 0) {
            outputView.strikeBall(strike, ball);
        } else if (strike > 0) {
            outputView.onlyStrike(strike);
        } else if (ball > 0) {
            outputView.onlyBall(ball);
        } else if (strike == 0 && ball == 0) {
            outputView.nothing();
        }
    }

    private void threeStrikeProcess(GameStateDto gamestate, int strike) {
        threeThrikeOutput(strike);
        gamestate.activateEndGame();
    }

    private void threeThrikeOutput(int strike) {
        outputView.onlyStrike(strike);
        outputView.endGame();
        outputView.restart();
    }


    private String getComputerNumber() {
        ComputerNumberGenerator generator = ComputerNumberGenerator.getInstance();
        return validator.validateNumber(generator.generate());
    }

    private String getUserNumber() {
        String inputUserNumber = inputView.readUserNumber();
        return validator.validateNumber(inputUserNumber);
    }


}
