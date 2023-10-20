package baseball.controller;

import baseball.domain.Opponent;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        Player player = new Player();
        Opponent opponent = new Opponent();

        repeatGuessingAnswerNumbers(player, opponent);
    }

    private void repeatGuessingAnswerNumbers(Player player, Opponent opponent) {
        outputView.printGameStartView();

        while (true) {
            String guessNumbers = inputView.readGuessNumbers();
            List<Integer> guessNumberList = new ArrayList<>();

            for (char c : guessNumbers.toCharArray()) {
                guessNumberList.add(Character.getNumericValue(c));
            }
            player.compareToAnswerNumbers(opponent, guessNumberList);
        }
    }
}
