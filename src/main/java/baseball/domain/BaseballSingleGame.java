package baseball.domain;

import exception.DuplicateBaseBallNumber;
import exception.OutOfBaseBallNumbersSize;

public class BaseballSingleGame implements BaseBallGame {

    private final MatchPlayer matchPlayer;


    public BaseballSingleGame(MatchPlayer matchPlayer) {
        this.matchPlayer = matchPlayer;
    }

    @Override
    public BaseBallHint checkBaseBallNumber(AnswerNumbers baseBallNumber) {
        return matchPlayer.getHintOf(baseBallNumber);
    }

    public void play(Player player, MatchPlayer matchPlayer) {
        player.showStartGameMessage();
    }

    private void startGame(Player player, MatchPlayer matchPlayer) {
        while (true) {
            final AnswerNumbers playerAnswerNumbers = getAnswerOf(player);
            // 변경을 받아서 상대에게 물어봐야합니다.
            // 상대방은 힌트를 주어야해요.
            final BaseBallHint baseBallHint = matchPlayer.getHintOf(playerAnswerNumbers);
            // 그리고 그 힌트가 3 strike 라면 게임이 종료되어야해요.
            // 그리고 유저에게 다시 할것인지 물어봐야해요.
            // 물어보고 다시 한다하면 게임을 다시 만들어야해요.
            // 근데 그건 여기서 할 일이 아니에요... application 에서 해야해요..
            player.printBaseBallHint(baseBallHint);
            if (baseBallHint.isNothing()) {
                break;
            }
        }
    }

    @Override
    public AnswerNumbers getAnswerOf(Player player) {
        try {
            final String[] playerAnswerStrings = player.getBaseballNumbers().split("");
            return AnswerNumbers.of(playerAnswerStrings);
        } catch (NumberFormatException | OutOfBaseBallNumbersSize | DuplicateBaseBallNumber e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 서로 다른 3개의 숫자를 입력해주세요.");
        }
    }
}
