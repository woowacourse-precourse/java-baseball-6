package baseball;

public class Application {
    private GamePlayer player;
    public Application(){
        player = new GamePlayer();
    }
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
    public void run(){
        player.playGameByRequest();
    }
}
