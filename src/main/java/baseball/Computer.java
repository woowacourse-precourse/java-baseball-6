package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Baseball.MAX_NUMBER;
import static baseball.Baseball.MIN_NUMBER;
import static baseball.Baseballs.BASEBALLS_SIZE;

public class Computer {
    private final Baseballs baseballs;

    public Computer(Baseballs baseballs) {
        this.baseballs = createBaseballs();
    }

    public Baseballs createBaseballs() {
        try {
            List<Baseball> baseballs = new ArrayList<>();
            for (int i = 0; i < BASEBALLS_SIZE; i++) baseballs.add(new Baseball(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
            return new Baseballs(baseballs);
        } catch (IllegalArgumentException e) {
            return createBaseballs();
        }
    }

}
