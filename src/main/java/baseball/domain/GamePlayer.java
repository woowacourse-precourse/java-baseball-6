package baseball.domain;

abstract class GamePlayer extends BaseBallGameRule {

    public abstract Boolean checkFinishGame();

    public abstract void fight(Computer computer);
}
