package baseball.convertor;

import baseball.domain.game.GameStatus;
import baseball.domain.game.Player;
import baseball.view.InputView;
import java.util.Arrays;
import java.util.List;

public class InputConvertor {
    private final InputView inputView;

    public InputConvertor(InputView inputView) {
        this.inputView = inputView;
    }

    public Player convertToPlayer() {
        String input = inputView.inputOtherThreeNumbers();
        List<Integer> playerInput = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
        return Player.of(playerInput);
    }

    public GameStatus convertToGameStatus() {
        String input = inputView.inputGameStatus();
        return GameStatus.of(input);
    }
}
