package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameManager;
import baseball.model.GameResult;
import baseball.model.User;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.ResultView;


public class GameController {
    private Computer computer;
    private User user;
    private GameManager gameManager;

    private InputView inputView;
    private ResultView resultView;

    private GameService gameService;

    private final String PLAY_GAME = "1";
    private final String END_GAME = "2";


    public GameController(Computer computer, User user, GameManager gameManager,
                          InputView inputView, ResultView resultView,
                          GameService gameService) {
        this.computer = computer;
        this.user = user;
        this.gameManager = gameManager;

        this.inputView = inputView;
        this.resultView = resultView;

        this.gameService = gameService;

        initializeGame();
    }

    public void run() {
        while (gameContinue()) {
            playOneRound();
            if (userWon()) {
                endOrContinueGame();
            }
        }
    }

    private void initializeGame() {
        resultView.printInit();
        computer.generateNumbers();
        gameManager.setPlayMode(PLAY_GAME);
    }

    private boolean gameContinue() {
        return !gameManager.isEndMode();
    }

    private void playOneRound() {
        user.setUserNumber(inputView.inputUserNumber());
        GameResult result = calculateResult();

        if (!userWon()) {
            printCurrentResult(result);
        }
    }

    private GameResult calculateResult() {
        return gameService.getResult(computer.getComNumber(), user.getUserNumber());
    }

    private boolean userWon() {
        return calculateResult().isAllStrikes();
    }

    private void printCurrentResult(GameResult result) {
        resultView.printBallAndStrikeCounts(result);
    }

    private void endOrContinueGame(){
        printWinMessage();

        String userInput = inputView.endOrContinuePrompt();

        if(userInput.equals(END_GAME)){
            setEndMode();
        } else if(userInput.equals(PLAY_GAME)){
            resetComputerNumbers();
        }
    }

    private void printWinMessage() {
        resultView.printWin();
    }

    private void setEndMode() {
        gameManager.setEndMode();
    }

    private void resetComputerNumbers() {
        computer.getComNumber().clear();
        computer.generateNumbers();
    }
}
