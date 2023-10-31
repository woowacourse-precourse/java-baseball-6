package racingcar.view;

import static racingcar.constants.MessageUtils.GAME_CYCLE;
import static racingcar.constants.MessageUtils.GAME_START;

public class OutView {

    public OutView() {
        this.racingStartMsg();
    }

    public void racingStartMsg() {
        System.out.println(GAME_START.getMessage());
    }

    public void racingCycleMsg() {
        System.out.println(GAME_CYCLE.getMessage());
    }
}
