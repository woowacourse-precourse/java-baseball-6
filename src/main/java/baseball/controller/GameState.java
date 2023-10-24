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
        if (isAbleToStart()) {
            this.state = State.PLAYING;
        } else {
            throw new IllegalStateException("게임을 시작할 수 없는 상태입니다.");
        }
    }

    private boolean isAbleToStart() {
        return this.state == State.TERMINATED;
    }

    public void changeStateToTerminateGame() {
        if (isAbleToTerminate()) {
            this.state = State.TERMINATED;
        } else {
            throw new IllegalStateException("게임을 시작할 수 없는 상태입니다.");
        }
    }

    private boolean isAbleToTerminate() {
        return this.state == State.PLAYING;
    }

    public boolean isPlaying() {
        return this.state == State.PLAYING;
    }

    public State getState() {
        return state;
    }
}
