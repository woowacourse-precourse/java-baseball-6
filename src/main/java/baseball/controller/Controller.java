package baseball.controller;

import baseball.domain.Baseball;
import baseball.utils.ErrorMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.*;

// Controller -> model <-> View
public class Controller {

    private static final String GAME_END_INPUT = "1";
    private static final String GAME_RESTART_INPUT = "2";
    private static final int MAKE_NUMBER_SIZE_MIN = 3;

    private Baseball baseball;
    private boolean gameSituation;
    private final boolean checkBaseballSituation;
    private boolean restartSituation;

    public Controller() {
        gameSituation = true;
        checkBaseballSituation = true;
        restartSituation = false;
    }

    public void run() {
        while (gameSituation) {
            init();
            playBaseballGame();
            restartGame();
        }
    }

    private void init() {
        baseball = new Baseball();
        List<Integer> insertComputerNumber = baseball.getComputerNumber();
        System.out.println("insertComputerNumber = " + insertComputerNumber);
        OutputView.printStartGame();
    }

    private void playBaseballGame() {
        while (checkBaseballSituation) {
            OutputView.printInsertNumber();
            List<Integer> insertUserNumber = generateUserAnswer();
            Map<String, Integer> resultBaseball = baseball.checkToStrikeAndBall(insertUserNumber);
            OutputView.printBaseBallResults(resultBaseball);
            String STRIKE = "strike";
            if (resultBaseball.get(STRIKE) == 3) {
                restartSituation = true;
                break;
            }
        }
    }

    private List<Integer> generateUserAnswer() {
        try {
            List<Integer> userAnswer = getUserInput();
            validateUserAnswerInput(userAnswer);
            return userAnswer;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return generateUserAnswer();
        }
    }


    private List<Integer> getUserInput() {
        List<Integer> userAnswer = new ArrayList<>();
        String input = InputView.commandUserInput();
        String[] splitInput = input.split("");
        for (String userInput : splitInput) {
            try {
                int convertInt = Integer.parseInt(userInput);
                userAnswer.add(convertInt);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
            }
        }
        return userAnswer;
    }

    private void validateUserAnswerInput(List<Integer> userAnswer) {
        for (Integer input : userAnswer) {
            if (input < 1) {
                throw new IllegalArgumentException(ErrorMessage.INSERT_USER_NUMBER_SIZE_ERROR.getMessage());
            }
        }

        if (userAnswer.size() != MAKE_NUMBER_SIZE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NUMBER_SIZE_THREE.getMessage());
        }

        Set<Integer> validation = new HashSet<>(userAnswer);
        if (validation.size() != MAKE_NUMBER_SIZE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NUMBER_NOT_DUPLICATION.getMessage());
        }
    }

    private void restartGame() {
        while (restartSituation) {
            OutputView.printAskRestart();
            String userInput = InputView.commandUserInput();
            if (Objects.equals(userInput, GAME_END_INPUT)) {
                restartSituation = false;
            }

            if (Objects.equals(userInput, GAME_RESTART_INPUT)) {
                gameSituation = false;
                break;
            }
        }
    }
}
