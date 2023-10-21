package baseball;

import baseball.game.hitter.Hitter;
import baseball.game.hitter.PlayerHitterImpl;
import baseball.game.pitcher.ComputerRandomPitcherImpl;
import baseball.game.pitcher.Pitcher;

public class AppConfig {
    //Hitter Setting
    public static final int DIGIT_NUM = 3;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 0;
    public static final char MAX_CHAR = '9';
    public static final char MIN_CHAR = '0';

    public Hitter hitter() {
        return new PlayerHitterImpl();
    }

    public Pitcher pitcher() {
        return new ComputerRandomPitcherImpl();
    }
}
