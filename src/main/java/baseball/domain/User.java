package baseball.domain;

import java.util.List;

public class User {

    private final NumberBaseballIO numberBaseballIO;

    public User(NumberBaseballIO numberBaseballIO) {
        this.numberBaseballIO = numberBaseballIO;
    }

    public List<Integer> guessAnswer(int numberLength) {
        return numberBaseballIO.inputGuessAnswer(numberLength);
    }
}
