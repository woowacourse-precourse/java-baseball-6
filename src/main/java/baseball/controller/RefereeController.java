package baseball.controller;

import baseball.domain.player.Player;
import baseball.domain.referee.Referee;
import baseball.domain.result.Result;
import baseball.view.BaseBallView;

public class RefereeController {

    private static final BaseBallView baseBallView = BaseBallView.create();

    private RefereeController() {
    }

    public static Result umpiredNumbers(Player player, Player opponent) {
        Referee referee = Referee.create();
        Result result = referee.calculateResult(player.getNumbers(), opponent.getNumbers());

        baseBallView.resultGameView(result.toString());

        return result;
    }
}
