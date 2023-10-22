package baseball;

public interface PlayerInputHandler <T> {
    public void handle(String playerInput);
    public T getHandledResult();
}
