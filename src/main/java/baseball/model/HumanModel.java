package baseball.model;

import java.util.List;

public class HumanModel {
    private final List<Integer> humans;

    public HumanModel(List<Integer> humans) {
        this.humans = humans;
    }

    public List<Integer> getHumans() {
        return humans;
    }
}
