package baseball.collaborator.number.generator;

import java.util.List;

public class OneTwoThreeNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        return List.of(1, 2, 3);
    }

}
