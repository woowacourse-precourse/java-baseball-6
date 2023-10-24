package baseball;

public class Application {
    private GameParticipant player;
    public Application(){
        player = new GameParticipant();
    }
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
    public void run(){
        player.playGameByRequest();
    }
}
