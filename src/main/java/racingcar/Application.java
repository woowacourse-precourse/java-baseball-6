package racingcar;

import racingcar.domain.numbergenerator.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController(new RandomNumberGenerator());
        controller.start();
    }
}
