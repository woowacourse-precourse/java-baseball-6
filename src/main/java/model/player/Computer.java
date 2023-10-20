package model.player;

import java.util.List;
import model.system.ValidNumberChecker;

public class Computer implements Player, RandomNumber {

    private Computer(List<Integer> OtherNumbers) {
    }

    @Override
    public List<Integer> createRandomNumbers() {
        return null;
    }

    public static Computer create(ValidNumberChecker validNumberChecker) {
        return new Computer(null);
    }

}
