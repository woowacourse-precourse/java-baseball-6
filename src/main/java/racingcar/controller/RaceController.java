package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutView;

public class RaceController {

    private final OutView outView;
    private final InputView inputView;
    private final RaceService racingService;
    private static int GAME_CYCLE_COUNT = 0;

    public RaceController() {
        this.inputView = new InputView();
        this.outView = new OutView();
        this.racingService = new RaceService();
    }

    public void run() {
        do {
            play();
        } while (GAME_CYCLE_COUNT-- > 0);
    }

    public void play() {
    }

    public void stop() {
    }

    public void racingCycle() {
    }
}
