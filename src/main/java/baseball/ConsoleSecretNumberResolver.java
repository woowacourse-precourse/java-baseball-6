package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleSecretNumberResolver extends AbstractSecretNumberResolver {
    @Override
    protected List<Integer> resolveIntegers() {
        return Stream.of(Console.readLine().split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
