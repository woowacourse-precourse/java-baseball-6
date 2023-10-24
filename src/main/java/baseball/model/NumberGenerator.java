package baseball.model;

@FunctionalInterface
public interface NumberGenerator {

    int generate(int min, int max);

}
