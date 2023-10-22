package baseball.controller;

import static baseball.converter.BaseBallConverter.stringToNumbers;

import baseball.domain.number.Numbers;
import baseball.domain.player.Player;
import baseball.domain.result.Result;
import baseball.view.BaseBallView;

public class PlayerController {
    private static final BaseBallView baseBallView = BaseBallView.create();

    private PlayerController() {
    }

    public static void startBattle(Player opponent) {
        boolean isContinueBattle = Boolean.TRUE;

        while (isContinueBattle) {
            Numbers numbers = stringToNumbers(baseBallView.numbersInputView());
            Player player = Player.create(numbers);

            Result result = RefereeController.umpiredPlayers(player, opponent);

            isContinueBattle = result.isContinue();
        }
    }

}
