package baseball;


public class Application {
    public static void main(String[] args) {

        // 요소들 게임 엔진에 주입 및 게임 실행
        NumberBaseballGameConfig config = new NumberBaseballGameConfig();
        GameEngine gameEngine = new GameEngine(
                config.getInputReader(),
                config.getAnnouncer(),
                config.getReferee(),
                config.getRandomNumberGenerator());
        gameEngine.run();
    }
}
