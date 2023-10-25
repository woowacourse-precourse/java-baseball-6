package baseball.constants;

public class NumberConstants {
    public static final int RESTART = 1;
    public static final int QUIT = 2;
    public static final int MAX_STRIKE = 3;

    public boolean wantRestart(int number) {
        return number == RESTART;
    }

    public boolean wantQuit(int number) {
        return number == QUIT;
    }
}
