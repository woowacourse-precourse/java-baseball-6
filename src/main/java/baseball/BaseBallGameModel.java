package baseball;

public class BaseBallGameModel {

    private int[] ballCount;
    private int size;

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
