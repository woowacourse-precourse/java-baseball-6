package baseball;

public class Application {
    public static void main(String[] args) {
        GameClient gameClient = new GameClient();
        do {
            gameClient.playBaseball();
        } while (gameClient.askForReplay());
    }
}
