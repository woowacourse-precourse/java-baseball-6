package baseball;

public class Application {
    public static void main(String[] args) {
        Person person = new Person();
        Computer computer = new Computer();
        GameScore gameScore = new GameScore(person, computer);
        GameRunner gameRunner = new GameRunner(person, computer, gameScore);

        gameRunner.playGame();
    }
}
