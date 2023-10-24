package baseball.controller;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.NumberBaseballGame;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGameController {

    public void run() {
        Computer computer = new Computer();
        Player player = new Player();
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        repeatGame(numberBaseballGame, player, computer);
    }

    private void repeatGame(NumberBaseballGame numberBaseballGame, Player player, Computer computer) {
        do {
            startGameOnce(numberBaseballGame, player, computer);
            playMoreGame(player);
        } while (player.isRestartGame());
    }

    private void startGameOnce(NumberBaseballGame numberBaseballGame, Player player, Computer computer) {
        settingGame(numberBaseballGame, computer);
        do {
            play(numberBaseballGame, player, computer);
        } while (numberBaseballGame.stillPlayingGame());
    }

    private void settingGame(NumberBaseballGame numberBaseballGame, Computer computer) {
        numberBaseballGame.startGame();
        computer.createRandomNumbers();
    }

    private void play(NumberBaseballGame numberBaseballGame, Player player, Computer computer) {
        int[] answerNumbers = getAnswerNumbersFromPlayer(player);
        String hintMessage = computer.hintAboutStrikeAndBall(answerNumbers);
        OutputView.showHintMessage(hintMessage);
        isSuccessGame(numberBaseballGame, computer);
    }

    private int[] getAnswerNumbersFromPlayer(Player player) {
        List<Integer> responseAnswerNumbers = InputView.requestAnswerNumbers();
        return player.receiveAnswerNumbers(responseAnswerNumbers);
    }

    private void isSuccessGame(NumberBaseballGame numberBaseballGame, Computer computer) {
        if (computer.isSuccess() == Boolean.TRUE) {
            numberBaseballGame.closeGame();
            OutputView.showSuccessMessage();
        }
    }

    private void playMoreGame(Player player) {
        String responsePlayMoreGame = InputView.requestPlayMoreGame();
        player.receivePlayMoreGame(responsePlayMoreGame);
    }
}