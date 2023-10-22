package baseball.domain.game;

public enum GameOption {
    RESTART(1),END(2);
    public int option;

    GameOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}
