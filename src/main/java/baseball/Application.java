package baseball;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.executeGame();
    }
}
