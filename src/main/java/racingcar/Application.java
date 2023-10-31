package racingcar;

import racingcar.controller.RaceController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceController raceController = new RaceController();
        raceController.run();
        raceController.stop();
    }
}
