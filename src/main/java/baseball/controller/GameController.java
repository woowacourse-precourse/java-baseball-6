package baseball.controller;

import baseball.domain.Opponent;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final static int RESTART = 1;
    private final static int GAME_END = 2;
    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        Player player = new Player();
        Opponent opponent = new Opponent();

        outputView.printGameStartView();
        repeatGuessingAnswerNumbers(player, opponent);
    }

    private void repeatGuessingAnswerNumbers(Player player, Opponent opponent) {
        while (true) {
            String guessNumbers = inputView.readGuessNumbers();
            List<Integer> guessNumberList = new ArrayList<>();

            for (char c : guessNumbers.toCharArray()) {
                guessNumberList.add(Character.getNumericValue(c));
            }
            player.compareToAnswerNumbers(opponent, guessNumberList);
            outputView.printHintView(player);

            if (checkNumbersEqualToAnswer(player)) {
                outputView.printGameEndView();
                checkForRestartOrShutDown(player);
                break;
            }
        }
    }

    private boolean checkNumbersEqualToAnswer(Player player) {
        return player.isEqualToAnswerNumbers();
    }

    private void checkForRestartOrShutDown(Player player) {
        String inputString = inputView.readRestartOrShutDown();
        int restartCheckNum = Integer.parseInt(inputString);
        validateRestartCheckNum(restartCheckNum);

        if (restartCheckNum == GAME_END) {
            return;
        }

        if (restartCheckNum == RESTART) {
            repeatGuessingAnswerNumbers(player, new Opponent());
        }
    }

    private void validateRestartCheckNum(int restartCheckNum) {
        if (!(restartCheckNum == 1 || restartCheckNum == 2)) {
            throw new IllegalArgumentException();
        }
    }
}
