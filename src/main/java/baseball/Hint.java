package baseball;

public class Hint {
    private int ball;
    private int strike;

    public Hint() {
    }

    public static Hint getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Hint INSTANCE = new Hint();
    }
}
