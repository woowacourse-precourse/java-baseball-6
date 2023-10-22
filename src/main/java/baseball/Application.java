package baseball;

public class Application {
    public static void main(String[] args) {
        Person person = new Person();
        Computer computer = new Computer();
        GameRunner gameRunner = new GameRunner(person, computer);

        gameRunner.playGame();
    }
}
