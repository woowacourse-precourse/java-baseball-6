package baseball.service;

import baseball.model.Computer;
import baseball.model.Score;

public class Game {
    public void start() {
        Computer computer = new Computer();
        do {
            Inning inning = new Inning();
            Score score = inning.doInning(computer);
        } while ();
    }


}
