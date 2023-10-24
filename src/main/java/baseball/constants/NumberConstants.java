package baseball.constants;

public class NumberConstants {
    private final int RESTART = 1;
    private final int QUIT = 2;

    public boolean wantRestart(int number) {
        return number == RESTART;
    }

    public boolean wantQuit(int number) {
        return number == QUIT;
    }
}
