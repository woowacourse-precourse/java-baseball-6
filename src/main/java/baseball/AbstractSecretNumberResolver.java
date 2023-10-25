package baseball;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractSecretNumberResolver implements SecretNumberResolver {
    public SecretNumber resolve() {
        return new SecretNumber(resolveDigits());
    }

    private List<Digit> resolveDigits() {
        return resolveIntegers()
            .stream()
            .map(Digit::from)
            .collect(Collectors.toList());
    }

    protected abstract List<Integer> resolveIntegers();
}
