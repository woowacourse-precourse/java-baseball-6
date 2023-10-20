package baseball.util.generator;

@FunctionalInterface
public interface Generator<T> {
	T generate();
}
