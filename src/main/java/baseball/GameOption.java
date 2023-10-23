package baseball;

public enum GameOption {
    RESTART_GAME(1),
    QUIT_GAME(2);

    private final int option;

    GameOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}
