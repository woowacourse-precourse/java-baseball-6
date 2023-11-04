package baseball;
public class Application {

    public static void main(String[] args) {
        GameLauncher launcher = new NumberBaseBallGameLauncher();
        launcher.startGame();
    }
}
