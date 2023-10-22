package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final int NUMBER_LENGTH = 3;
    private static final int FULL_STRIKE_COUNT = 3;
    private static final char ZERO_CHAR = '0';
    private static final String SPACE_MESSAGE = " ";
    private static final String NULL_MESSAGE = "";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Computer computer;
    Player player;
    Game game;

    public void startGame() {
        boolean continueGame = true;

        outputView.printStartMessage();

        while(continueGame) {
            playGame();
            continueGame = askRestartGame();
        }
    }

    public void playGame() {
        computer = new Computer();
        player = new Player();
        game = new Game();

        computer.setComputerNumbers(getRandomNumbers());
        do {
            player.setPlayerNumbers(convertplayerToList(inputView.inputPlayerNumber()));
            game.initStrikeAndBall();
            countStrikeAndBall(player.getPlayerNumbers(), computer.getComputerNumbers());
            printHint();
        } while (!isCorrectNumber());

        outputView.printEndMessage();
    }

    public List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public List<Integer> convertplayerToList(String playerStr) {
        List<Integer> player = new ArrayList<>();
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            int number = playerStr.charAt(index) - ZERO_CHAR;
            player.add(number);
        }

        return player;
    }

    public void countStrikeAndBall(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            int playerNumber = playerNumbers.get(index);
            int computerNumber = computerNumbers.get(index);

            countStrike(playerNumber, computerNumber);
            countBall(computerNumbers, index, playerNumber);
        }
    }

    public void countStrike(int player, int computer) {
        if (player == computer) {
            game.plusStrikeCount(1);
        }
    }

    public void countBall(List<Integer> computers, int currentIndex, int player) {
        if (computers.get(currentIndex) != player && computers.contains(player)) {
            game.plusBallCount(1);
        }
    }

    public boolean isCorrectNumber() {
        if (game.getStrikeCount() == FULL_STRIKE_COUNT) {
            return true;
        }

        return false;
    }


    public void printHint() {
        String hintMessage = "";

        hintMessage += getBallMessage();
        hintMessage += getStrikeMessage();

        if (hintMessage.equals("")) {
            outputView.printHindMessage(NOTHING_MESSAGE);
            return;
        }

        outputView.printHindMessage(hintMessage);
    }

    public String getBallMessage() {
        if (game.getBallCount() > 0) {
            return game.getBallCount() + BALL_MESSAGE + SPACE_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    public String getStrikeMessage() {
        if (game.getStrikeCount() > 0) {
            return game.getStrikeCount() + STRIKE_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    public boolean askRestartGame() {
        String answer = inputView.askPlayerGameRestart();
        if (answer.equals("1")) {
            return true;
        }

        return false;
    }
}
