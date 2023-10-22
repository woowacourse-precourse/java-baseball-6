package baseball;

public class Application {
    public static void main(String[] args) {
        RandomGenerator randomGenerator = new DefaultRandomGenerator();
        Person person = new Person();
        Computer computer = new Computer(randomGenerator);
        GameRunner gameRunner = new GameRunner(person, computer);

        gameRunner.playGame();
    }
}
