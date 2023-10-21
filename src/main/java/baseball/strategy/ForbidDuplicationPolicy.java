package baseball.strategy;

public class ForbidDuplicationPolicy implements DuplicateAllowancePolicy {

    @Override
    public boolean canBeDuplicated() {
        return false;
    }

}
