package baseball.object.number;

import baseball.object.number.generator.NumbersGenerator;
import java.util.List;

public class OneTwoThreeOrFakeNumberGenerator implements NumbersGenerator {

    private int first = 1;
    private int second = 2;
    private int third = 3;

    public OneTwoThreeOrFakeNumberGenerator() {
    }

    public OneTwoThreeOrFakeNumberGenerator(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public List<Integer> generate() {
        return List.of(first, second, third);
    }

}
