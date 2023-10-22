package baseball.modules.player;

import baseball.utils.BaseballNumberGenerator;
import java.util.List;

public class Computer extends BaseballPlayer {

    public Computer() {
        super(BaseballNumberGenerator.generate());
    }

    public Computer(final String input){ super(input);}
}
