package racingcar.controller;

import static racingcar.constants.MessageUtils.RACE_RESULT;
import static racingcar.utils.GameValidator.isNumeric;
import static racingcar.utils.GameValidator.validateCheckGameCycle;

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
        this.racingService = new RaceService(inputView);
        racingCycle();
        validateCheckGameCycle(GAME_CYCLE_COUNT);
    }

    public void run() {
        System.out.println(RACE_RESULT.getMessage());
        do {
            play();
        } while (GAME_CYCLE_COUNT-- > 0);
    }

    public void play() {
        racingService.start();
    }

    public void stop() {
        racingService.getWinner();
    }

    public void racingCycle() {
        outView.racingCycleMsg();
        GAME_CYCLE_COUNT = Integer.parseInt(isNumeric(inputView.commonFromInput()));
        System.out.println();
    }
}
