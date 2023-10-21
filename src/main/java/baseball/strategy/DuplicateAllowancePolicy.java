package baseball.strategy;

@FunctionalInterface
public interface DuplicateAllowancePolicy {

    boolean canBeDuplicated();

}
