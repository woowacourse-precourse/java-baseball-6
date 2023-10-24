package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.PlayerAnswer;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static final int FIXED_LIST_SIZE = 3;
    private static final int MIN_OF_NUMBER_RANGE = 1;
    private static final int MAX_OF_NUMBER_RANGE = 9;
    private static final String GAME_RESTART_NUMBER = "1";
    private static final String GAME_EXIT_NUMBER = "2";

    Computer computer = new Computer();
    Player player = new Player();
    ComputerController computerController = new ComputerController();
    GameView gameView = new GameView();
    PlayerAnswer playerAnswer = new PlayerAnswer();

    public void playGame() {
        List<Integer> computerRandomNumberList;
        boolean proceedGameFlag = true;

        gameView.printStartGameMessage();

        while (proceedGameFlag) {
            computerRandomNumberList = computer.getComputerRandomNumber();
            proceedGameFlag = repeatFindAnswer(computerRandomNumberList);
        }
    }

    private boolean repeatFindAnswer(List<Integer> computerRandomNumberList) {
        List<Integer> playerNumberList = new ArrayList<>();
        boolean correctAnswerFlag = false;
        String playerRetry;

        while (!correctAnswerFlag) {
            gameView.printInputNumberMessage();
            playerNumberList = player.getPlayerNumberList(Console.readLine());

            validate(playerNumberList);

            correctAnswerFlag = compareAnswer(computerRandomNumberList, playerNumberList);
            gameView.printAnswerHintMessage(playerAnswer.getHint());

            if (correctAnswerFlag) {
                gameView.printSuccessGameMessage();
                playerRetry = Console.readLine();
                correctAnswerFlag = retryGame(playerRetry);
                break;
            }
        }

        return correctAnswerFlag;
    }

    private boolean compareAnswer(List<Integer> computerRandomNumberList, List<Integer> playerNumberList) {
        playerAnswer.initCountZero();

        for (int i = 0; i < FIXED_LIST_SIZE; i++) {
            playerAnswer.countStrikeAndBall(computerRandomNumberList, playerNumberList, i);
        }

        return playerAnswer.checkThreeStrike();
    }

    private boolean retryGame(String playerOption) {
        switch (playerOption) {
            case GAME_RESTART_NUMBER: return true;

            case GAME_EXIT_NUMBER: return false;

            default: throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> playerNumberList) {
        if (playerNumberList.size() != FIXED_LIST_SIZE) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < playerNumberList.size(); i++) {
            checkNumberRange(playerNumberList, i);
        }

        if (playerNumberList.size() != playerNumberList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberRange(List<Integer> playerNumberList, int index) {
        if (playerNumberList.get(index) < MIN_OF_NUMBER_RANGE || playerNumberList.get(index) > MAX_OF_NUMBER_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}
