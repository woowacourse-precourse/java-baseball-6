package baseball.controller;

import baseball.constants.AppConstants;
import baseball.model.GameScoreDTO;
import baseball.view.GameIO;
import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    private GameManager gameManager;
    private GameIO gameIO;

    public UserInputHandler() {
        this.gameIO = new GameIO();
        this.gameManager = new GameManager(this.gameIO);
    }
    public UserInputHandler(GameManager GameManager, GameIO gameIO) {
        this.gameManager = GameManager;
        this.gameIO = gameIO;
    }
    public List<Integer> getUserInput() {
        try {
            gameIO.printInputNumber();
            String input = gameIO.getUserGameInput();
            validateInput(input);

            return parseInput(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(AppConstants.ERR_WRONG_INPUT);
        }
    }

    private void validateInput(String input) {
        String regex = AppConstants.REGEX_VALID_INPUT;
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(AppConstants.ERR_INVALID_NUMBER_INPUT);
        }
    }

    private List<Integer> parseInput(String input) {
        List<Integer> resultList = new ArrayList<>();
        String[] splitArray = input.split("");
        for (String string : splitArray) {
            int num = Integer.parseInt(string);
            resultList.add(num);
        }
        return resultList;
    }

    public boolean isContinueGame(GameScoreDTO gameScoreDTO) {
        if(gameScoreDTO ==null) {
            return false;
        }
        if (!gameScoreDTO.isGameOver()) {
            return true;
        }
        gameIO.printGameMsg();
        String input = gameIO.getContinueGameString();
        String regex = AppConstants.REGEX_CONTINUE_VALUE;

        if(!input.matches(regex)) {
            throw new IllegalArgumentException(AppConstants.ERR_INVALID_RESTART_VALUE);
        }
        if ( "1".equals(input)) {
            gameManager.initializeNewGame();
            gameScoreDTO.setGameOver(false);
            return true;
        }
        return false;
    }
}