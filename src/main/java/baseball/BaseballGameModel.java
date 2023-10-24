package baseball;

public class BaseballGameModel {

    private final int[] ballCount;
    private final int size;

    public BaseballGameModel(int[] ballCount, int size) {
        this.ballCount = ballCount;
        this.size = size;
    }

    public int[] getBallCount() {
        return ballCount;
    }

    public int getSize() {
        return size;
    }
}
