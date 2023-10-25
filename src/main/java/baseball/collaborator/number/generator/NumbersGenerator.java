package baseball.collaborator.number.generator;

import java.util.List;

public interface NumbersGenerator {

    int NUMBERS_SIZE = 3;

    List<Integer> generate();

}
