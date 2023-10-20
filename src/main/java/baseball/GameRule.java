package baseball;

public class GameRule {

    private int goalNumberLength;
    private int minInclude;
    private int maxInclude;

    public GameRule(int n, int minInclude, int maxInclude) {
        this.goalNumberLength = n;
        this.minInclude = minInclude;
        this.maxInclude = maxInclude;
    }

    public int getGoalNumberLength() {
        return goalNumberLength;
    }

    public int getMinInclude() {
        return minInclude;
    }

    public int getMaxInclude() {
        return maxInclude;
    }
}
