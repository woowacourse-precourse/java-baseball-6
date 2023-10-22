package player;

public abstract class BaseballPlayer {

    BaseballNumbers baseballNumbers;

    public abstract void inputBaseballNumbers();

    public BaseballNumbers getBaseballNumbers() {
        return this.baseballNumbers;
    }
}
