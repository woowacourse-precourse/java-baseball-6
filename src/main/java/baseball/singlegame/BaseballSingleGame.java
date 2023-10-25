package baseball.singlegame;

import baseball.domain.AnswerNumbers;
import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallHint;
import baseball.domain.GameState;
import baseball.domain.MatchPlayer;
import baseball.domain.Player;
import exception.DuplicateBaseBallNumber;
import exception.OutOfBaseBallNumbersSize;

public class BaseballSingleGame implements BaseBallGame {

    public BaseballSingleGame() {
    }

    @Override
    public void onCreateGame(Player player) {
        player.showStartGameMessage();
    }

    @Override
    public GameState play(Player player, MatchPlayer matchPlayer) {
        startGame(player, matchPlayer);
        player.printEndGameMessage();
        return GameState.of(player.checkRestart());
    }

    private void startGame(Player player, MatchPlayer matchPlayer) {
        while (true) {
            final AnswerNumbers playerAnswerNumbers = getAnswerOf(player);
            final BaseBallHint baseBallHint = matchPlayer.requestHintOf(playerAnswerNumbers);
            player.printBaseBallHint(baseBallHint);
            if (baseBallHint.hasThreeStrike()) break;
        }
    }

    private AnswerNumbers getAnswerOf(Player player) {
        try {
            final String[] playerAnswerStrings = player.getBaseballNumbers().split("");
            return AnswerNumbers.of(playerAnswerStrings);
        } catch (NumberFormatException | OutOfBaseBallNumbersSize | DuplicateBaseBallNumber e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 서로 다른 3개의 숫자를 입력해주세요.");
        }
    }
}
