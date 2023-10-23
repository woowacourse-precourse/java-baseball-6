package baseball;

public class Application {
    public static void main(String[] args) {
        // 요소들 초기화
        InputReader inputReader = new InputReader(new GuessedNumberValidator(), new ContinueModeNumberValidator());
        Referee referee = new Referee();
        Announcer announcer = new Announcer();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // 요소들 게임 엔진에 주입 및 게임 실행
        GameEngine gameEngine = new GameEngine(inputReader, announcer, referee, randomNumberGenerator);
        gameEngine.run();
    }
}
