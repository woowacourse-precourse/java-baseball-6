package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 인스턴스 생성
        UserInputManager userInputManager = new UserInputManager();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        // 의존성 주입 및 프로세스 시작
        final BaseballGame baseballGame = new BaseballGame(userInputManager, randomNumberGenerator ,scoreCalculator);
        baseballGame.startGame();
    }
}
