package baseball.controller;

import baseball.constant.NumberConstant;
import baseball.dto.PlayerGameStateDto;
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


    public void turnOnGame() {
        outputView.startMessage();
        computerNumber = getComputerNumber();
        try {
            playBall();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void playBall() {
        PlayerGameStateDto playerGameState;
        do {
            outputView.inputInitMessage();
            String userNumber = getUserNumber();
            BaseballService baseballService = new BaseballService(userNumber, computerNumber);
            playerGameState = baseballService.calculateStrikeBall();
            outputResult(playerGameState);
        } while (isGameRestart(playerGameState));
    }

    private boolean isGameRestart(PlayerGameStateDto playerGameState) {
        if (playerGameState.isEndGame()) {
            inputRestart(playerGameState);
            checkComputerNumberChange(playerGameState);
            return playerGameState.isRestart();
        }
        return true;
    }

    private void checkComputerNumberChange(PlayerGameStateDto playerGameState) {
        if (playerGameState.isRestart()) {
            computerNumber = changeComputerNumber();
        }
    }

    private String changeComputerNumber() {
        computerNumber = getComputerNumber();
        return computerNumber;
    }

    private void inputRestart(PlayerGameStateDto playerGameState) {
        String restartNumber = inputView.readRestart();
        validator.validateRestart(restartNumber);
        if (restartNumber.equals(RESTART)) {
            playerGameState.activateRestart();
        }
    }


    private void outputResult(PlayerGameStateDto playerGameState) {
        int strike = playerGameState.getStrike();
        int ball = playerGameState.getBall();
        if (strike == NumberConstant.THREE_STRIKE.getNumber()) {
            threeStrikeProcess(playerGameState, strike);
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

    private void threeStrikeProcess(PlayerGameStateDto playerGameState, int strike) {
        threeThrikeOutput(strike);
        playerGameState.activateEndGame();
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
