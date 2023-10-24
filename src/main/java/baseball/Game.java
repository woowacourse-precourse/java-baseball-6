package baseball;

public interface Game {
    Game createNewGame();
    void sayHello();
    void sayBi();
    void run();
    boolean shouldRetry();
}
