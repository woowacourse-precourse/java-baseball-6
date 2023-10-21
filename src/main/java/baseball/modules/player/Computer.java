package baseball.modules.player;

import baseball.utils.BaseballNumberGenerator;

public class Computer extends BaseballPlayer {

    public Computer() {
        super(BaseballNumberGenerator.generate());
    }
}
