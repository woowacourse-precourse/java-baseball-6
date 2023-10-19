package baseball;


import static baseball.GameMessages.*;

public class Application {
    public static void main(String[] args) {
        Person person = new Person();
        Computer computer = new Computer();
        GameUtils gameUtils = new GameUtils(person, computer);
        GameScore gameScore = new GameScore(person, computer);
        GameRunner gameRunner = new GameRunner(person, gameUtils, gameScore);

        printStartMessage();
        while (true) {
            if (gameRunner.playRound()) {
                return;
            }
        }
    }
}
