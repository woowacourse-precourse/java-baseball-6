package baseball;

public class AppConfig {

    public CodeRepository codeRepository() {
        return new CodeRepository();
    }

    public GameService gameService() {
        return new GameService(codeRepository());
    }

    public GameController gameController() {
        return new GameController(gameService());
    }

}
