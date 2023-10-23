package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Hint.Strike;
import baseball.service.StrikeService;

public class StrikeController {

    private static final StrikeService strikeService = StrikeService.getInstance();

    public static Strike create(Baseball computerBaseball, Baseball inputBaseball) {
        Strike strike = new Strike();

        strike.setCount(strikeService.count(computerBaseball, inputBaseball));
        strike.setActive(strikeService.active(strike));
        return strike;
    }

    public static boolean isActive(Strike strike) {
        return strike.isActive();
    }

}
