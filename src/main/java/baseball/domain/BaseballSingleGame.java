package baseball.domain;

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
            final AnswerNumbers baseBallNumber = player.getBaseballNumbers();
            // 여기에서 입력 받은 문자열을 실제 규칙에 맞는 값으로 변경
            // 변경을 받아서 상대에게 물어봐야합니다.
            // 상대방은 힌트를 주어야해요.
            // 그리고 그 힌트가 3 strike 라면 게임이 종료되어야해요.
            // 그리고 유저에게 다시 할것인지 물어봐야해요.
            // 물어보고 다시 한다하면 게임을 다시 만들어야해요.
            // 근데 그건 여기서 할 일이 아니에요... application 에서 해야해요..
            final BaseBallHint baseBallHint = matchPlayer.getHintOf(baseBallNumber);
            player.printBaseBallHint(baseBallHint);
            if (baseBallHint.isNothing()) {
                break;
            }
        }
    }
}
