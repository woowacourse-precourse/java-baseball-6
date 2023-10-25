package baseball.global.utils.generator;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

	List<Integer> generate();
}
