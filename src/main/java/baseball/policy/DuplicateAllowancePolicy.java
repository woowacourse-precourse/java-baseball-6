package baseball.policy;

@FunctionalInterface
public interface DuplicateAllowancePolicy {

    boolean canBeDuplicated();

}
