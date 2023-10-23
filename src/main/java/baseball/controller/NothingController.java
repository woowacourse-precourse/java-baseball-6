package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.hint.Nothing;
import baseball.service.hint.NothingService;

public class NothingController {

    private static final NothingService nothingService = NothingService.getInstance();

    public static Nothing create(Baseball computerBaseball, Baseball inputBaseball) {
        Nothing nothing = new Nothing();

        nothing.setCount(nothingService.count(computerBaseball, inputBaseball));
        nothing.setActive(nothingService.active(nothing));
        return nothing;
    }

    public static boolean isActive(Nothing nothing) {
        return nothing.isActive();
    }
}
