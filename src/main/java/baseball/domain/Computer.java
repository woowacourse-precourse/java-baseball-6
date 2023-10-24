package baseball.domain;

public class Computer {

    static BaseballNumbers generateComputerNumbers() {
        return GameFactory.createComputerNumbers();
    }
}
