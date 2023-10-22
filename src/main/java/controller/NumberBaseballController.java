package controller;

import static utils.GameConstant.GAME_RESTART_OR_QUIT_PROMPT;
import static utils.GameConstant.GAME_START_MESSAGE;
import static utils.GameConstant.GAME_WIN_MESSAGE;
import static utils.GameConstant.INPUT_PROMPT_MESSAGE;
import static utils.GameConstant.QUIT_GAME;

import java.util.List;
import model.player.Computer;
import model.player.User;
import model.referee.GameScoreboard;
import model.system.GameController;
import model.system.GameTerminator;
import utils.BaseballMessageConvertor;
import utils.BaseballNumberUtils;
import view.InputView;
import view.OutputView;

public class NumberBaseballController {

    private final GameController gameController;
    private final InputView inputView;
    private final OutputView outputView;

    public NumberBaseballController(GameController gameController, InputView inputView, OutputView outputView) {
        this.gameController = gameController;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        startGame();
        do {
            Computer computer = setupGame();
            playGame(computer);
        } while (!isUserWantToQuit());
    }

    private void startGame() {
        outputView.write(GAME_START_MESSAGE);
    }

    private void playGame(Computer computer) {
        List<Integer> userBaseballNumber = getUserBaseballNumber();
        User user = User.create(userBaseballNumber);
        GameScoreboard gameScoreboard = gameController.run(user, computer);
        String convertMessage = BaseballMessageConvertor.generateScoreMessage(gameScoreboard);
        outputView.write(convertMessage);
        GameTerminator gameTerminator = new GameTerminator();
        boolean gameStillRunning = gameTerminator.isGameStillRunning(gameScoreboard);
        if (gameStillRunning) {
            playGame(computer);
            return;
        }
        outputView.write(GAME_WIN_MESSAGE);
        outputView.write(GAME_RESTART_OR_QUIT_PROMPT);
    }

    private boolean isUserWantToQuit() {
        String input = inputView.readInput();
        return input.equals(QUIT_GAME);
    }

    private List<Integer> getUserBaseballNumber() {
        outputView.write(INPUT_PROMPT_MESSAGE);
        String input = inputView.readInput();
        return BaseballMessageConvertor.convertInputToBaseballNumber(input);
    }

    private Computer setupGame() {
        List<Integer> randomNumbers = BaseballNumberUtils.createRandomNumbers();
        return Computer.create(randomNumbers);
    }
}
