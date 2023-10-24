package baseball;


import baseball.service.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.playBaseballGame();
    }
}
