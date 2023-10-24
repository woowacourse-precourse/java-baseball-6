package baseball.controller;

import baseball.domain.ball.Balls;
import baseball.domain.game.Game;
import baseball.domain.game.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private Game game;

    public void run() {
        init();
        play();
        checkRestart();
    }

    private void init() {
        game = new Game();
    }
    private void play() {
        while (game.isRun()) {
            Balls playerBalls = createPlayerBalls();
            GameResult gameResult = game.compareBalls(playerBalls);
            OutputView.printResult(gameResult);
        }
    }
    private void checkRestart() {
        OutputView.printEnd();
        String command = InputView.askRestart();
        game.performCommand(command);
        if(game.isRun()) {
            play();
        }
    }

    private Balls createPlayerBalls() {
        String number = InputView.askNumber();
        validateNumber(number);
        List<Integer> numbers = stringToList(number);
        return new Balls(numbers);
    }

    private void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private List<Integer> stringToList(String number) {
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}
