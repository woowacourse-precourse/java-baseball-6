package baseball.domain.model;

@FunctionalInterface
public interface MessageFormatter {
    String format(int count);
}
