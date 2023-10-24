package baseball;

import java.util.List;

public class Game {

    public void play() {

        List<Integer> randomNumbers = RandomNumberGenerator.createNumbers();

        while (true) {
            List<Integer> userNumbers = UserNumberReader.read();
        }

    }
}
