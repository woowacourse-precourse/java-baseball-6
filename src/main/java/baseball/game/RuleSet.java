package baseball.game;

public enum RuleSet {
    BASIC(3);

    private final int numLen;

    RuleSet(int numLen) {
        this.numLen = numLen;
    }

    public int getNumLen() {
        return numLen;
    }
}
