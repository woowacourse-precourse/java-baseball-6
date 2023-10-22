package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.Player;
import baseball.utils.RandomUtil;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private static final int NUMBER_LENGTH = 3;
    private static final int ZERO = 0;
    private static final int FULL_STRIKE_COUNT = 3;
    private static final String SPACE_MESSAGE = " ";
    private static final String NULL_MESSAGE = "";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    RandomUtil randomUtil = new RandomUtil();
    Computer computer;
    Player player;
    Game game;

    public void startGame() {

        outputView.printStartMessage();

        do {
            playGame();
        } while(restartGame());
    }

    public void playGame() {
        computer = new Computer();
        player = new Player();
        game = new Game();

        computer.setComputerNumbers(randomUtil.generateRandomNumbers());
        do {
            String playerInput = inputView.inputPlayerNumber();
            player.setPlayerNumbers(playerInput);
            game.initStrikeAndBall();
            countStrikeAndBall(player.getPlayerNumbers(), computer.getComputerNumbers());
            printHintMessage();
        } while (!isCorrectNumber());

        outputView.printEndMessage();
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

    public void printHintMessage() {
        String hintMessage = NULL_MESSAGE;

        hintMessage += getBallMessage();
        hintMessage += getStrikeMessage();
        hintMessage += getNothingMessage();

        outputView.printHindMessage(hintMessage);
    }

    public String getBallMessage() {
        if (game.getBallCount() > ZERO) {
            return game.getBallCount() + BALL_MESSAGE + SPACE_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    public String getStrikeMessage() {
        if (game.getStrikeCount() > ZERO) {
            return game.getStrikeCount() + STRIKE_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    public String getNothingMessage() {
        if (game.getBallCount() == ZERO && game.getStrikeCount() == ZERO) {
            return NOTHING_MESSAGE;
        }
        return NULL_MESSAGE;
    }

    public boolean restartGame() {
        String answer = inputView.askPlayerGameRestart();
        if (answer.equals("1")) {
            return true;
        }

        return false;
    }
}
