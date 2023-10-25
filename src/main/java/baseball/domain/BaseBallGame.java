package baseball.domain;

public interface BaseBallGame {

    void onCreateGame(Player player);

    GameState play(Player player, MatchPlayer matchPlayer);
}
