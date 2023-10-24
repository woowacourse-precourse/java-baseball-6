package baseball.util;

import baseball.model.Number;
import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

    List<Number> generate();
}
