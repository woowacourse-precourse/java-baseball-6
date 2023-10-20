package baseball.domain;

import baseball.util.RandomNumberGenerator;

import java.util.List;

public class Computer {
    private List<Integer> number;

    public Computer() {
        number = RandomNumberGenerator.getRandom3Number();
    }

    public Computer(List<Integer> number) {
        this.number = number;
    }


}
