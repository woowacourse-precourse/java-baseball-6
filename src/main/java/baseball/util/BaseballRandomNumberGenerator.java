package baseball.util;

import java.util.List;

public class BaseballRandomNumberGenerator implements BaseballNumberGenerator{

    @Override
    public int generate() {
        return 0;
    }

    private static boolean isDuplicatedNumber(List<Integer> computerNumberList, int checkNumber){
        return computerNumberList.contains(checkNumber);
    }
}
