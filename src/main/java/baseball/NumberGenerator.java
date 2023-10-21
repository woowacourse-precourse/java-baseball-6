package baseball;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

    List<Integer> generate();
}
