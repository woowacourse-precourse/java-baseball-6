package baseball;


import baseball.util.OutputUtil;

public class Application {
    public static void main(String[] args) {
        Ground ground = new Ground();
        OutputUtil.printStartGame();
        ground.startGame();

    }
}
