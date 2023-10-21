package baseball.controller;

public class StateController {
    public static final int GAMESTATE_RESTART = 1;
    public static final int GAMESTATE_END = 2;
    private boolean gameState;


    public StateController() {
        this.gameState = true;
    }
}
