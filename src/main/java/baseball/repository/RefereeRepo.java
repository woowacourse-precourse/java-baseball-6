package baseball.repository;

import baseball.domain.RandomNumberGenerator;
import baseball.domain.Referee;

public class RefereeRepo {

    private static Referee referee;

    public static void save(Referee referee) {
        RefereeRepo.referee = referee;
    }

    public static Referee find() {
        return RefereeRepo.referee;
    }
}
