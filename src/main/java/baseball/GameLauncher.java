package baseball;

public interface GameLauncher{
    void startGame();

    void initGame();

    void endGame();

    void play(GameInputValue value); //TODO 확장성이 아쉬운 느낌 ..?
}
