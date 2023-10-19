package baseball;

public interface Game {
    void awake();
    void beforeLoop();
    void gameLoop();
    void afterLoop();
    void cleanup();
}
