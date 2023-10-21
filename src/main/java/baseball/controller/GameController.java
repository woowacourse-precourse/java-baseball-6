package baseball.controller;

import baseball.dto.GameStateDto;
import baseball.service.BaseballService;
import baseball.service.ComputerNumberGenerator;
import baseball.util.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private static String computerNumber;
    private final InputView inputView;
    private final OutputView outputView;
    private final Validation validation = new Validation();


    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void playball() {
        GameStateDto gamestate;
        computerNumber = getComputerNumber();
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
        validation.validateRestart(restartNumber);
        if (restartNumber.equals("1")) {
            gamestate.activateRestart();
        }
    }


    private void outputResult(GameStateDto gamestate) {
        int strike = gamestate.getStrike();
        int ball = gamestate.getBall();
        if (strike == 3) {
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
        return validation.validateNumber(generator.generate());
    }

    private String getUserNumber() {
        String inputUserNumber = inputView.readUserNumber();
        return validation.validateNumber(inputUserNumber);
    }


}
