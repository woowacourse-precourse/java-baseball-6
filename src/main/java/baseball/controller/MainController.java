package baseball.controller;

import baseball.model.GameData;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;

public class MainController {
    private static final int INIT_CODE = 1;
    private static final int GAME_END_CODE = 2;
    private static final int NO_COUNT = 0;
    private static final int THREE_STRIKES = 3;
    private static final String PLAYER_INIT_CODE = "1";
    private static final String PLAYER_GAME_END_CODE = "2";

    private static int state = INIT_CODE;
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    GameData gameData = new GameData();
    Validator validator = new Validator();
    RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
    PlayerInputController playerInputController = new PlayerInputController(validator);
    GameComparator gameComparator = new GameComparator();

    public MainController() {
        state = INIT_CODE;
    }

    public void playGame() {
        outputView.printGameStart();
        while (state == INIT_CODE) {
            gameData.setComputerNumber(randomNumbersGenerator.generateNumbers());
            processInputAndCompare();
        }
    }

    private void processInputAndCompare() {
        while (true) {
            processPlayerInput();
            if (gameComparator.isEndGame(gameData.getComputerNumber(), gameData.getPlayerInput())) {
                checkReplay();
                return;
            }
            processCompare();
        }
    }

    private void processPlayerInput() {
        String playerFirstInput = inputView.printNumberRequest();
        ArrayList<Integer> playerInput = playerInputController.handlePlayerInput(playerFirstInput);
        gameData.setPlayerInput(playerInput);
    }

    private void checkReplay() {
        outputView.printHint(NO_COUNT, THREE_STRIKES);
        String endNumber = inputView.printGameEnd();
        validator.validateGameEndInput(endNumber);

        if (endNumber.equals(PLAYER_INIT_CODE)) {
            MainController.state = INIT_CODE;
        } else if (endNumber.equals(PLAYER_GAME_END_CODE)) {
            MainController.state = GAME_END_CODE;
        }
    }

    private void processCompare() {
        boolean nothing = gameComparator.isNothing(gameData.getComputerNumber(), gameData.getPlayerInput());
        int ballCount = NO_COUNT;
        int strikeCount = NO_COUNT;

        if (!nothing) {
            ballCount = gameComparator.countBalls(gameData.getComputerNumber(), gameData.getPlayerInput());
            strikeCount = gameComparator.countStrikes(gameData.getComputerNumber(), gameData.getPlayerInput());
        }

        outputView.printHint(ballCount, strikeCount);
    }

}
