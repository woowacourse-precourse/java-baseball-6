package model.system;

import java.util.List;

public class DefaultValidNumberChecker implements ValidNumberChecker {

    public static final int VALID_SIZE = 3;

    @Override
    public boolean isValid(List<Integer> numbers) {
        return false;
    }
}
