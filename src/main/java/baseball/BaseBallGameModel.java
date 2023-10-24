package baseball;

public class BaseBallGameModel {

    private final int[] ballCount;
    private final int size;

    public BaseBallGameModel(int[] ballCount, int size) {
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
