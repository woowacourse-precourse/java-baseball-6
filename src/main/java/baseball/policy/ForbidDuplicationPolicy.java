package baseball.policy;

public class ForbidDuplicationPolicy implements DuplicateAllowancePolicy {

    @Override
    public boolean canBeDuplicated() {
        return false;
    }

}
