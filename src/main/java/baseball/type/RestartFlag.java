package baseball.type;

public enum RestartFlag {
    RESTART(1),
    END(2);

    final int number;

    RestartFlag(int number) {
        this.number = number;
    }

    public static boolean isRestart(String number) {
        return number.equals(RESTART.getNumbertoString());
    }

    public static boolean isEnd(String number) {
        return !isRestart(number);
    }

    public String getNumbertoString() {
        return String.valueOf(number);
    }
}
