package baseball.collaborator.number.generator;

import java.util.List;

public class FakeNumbersGenerator implements NumbersGenerator {

    private int first;
    private int second;
    private int third;

    public FakeNumbersGenerator(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public List<Integer> generate() {
        return List.of(first, second, third);
    }

}
