package baseball.controller;

public class GameState {

    enum State {
        TERMINATED, PLAYING;
    }

    private State state;

    public GameState(State state) {
        this.state = state;
    }

    public void changeStateToStartGame() {
        // TODO : 구현 필요
        this.state = State.PLAYING;
    }

    private boolean isAbleToStartGame() {
        // TODO : 구현 필요
        return true;
    }

    public State getState() {
        return state;
    }
}
