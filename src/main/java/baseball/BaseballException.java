package baseball;

import java.util.List;

public class BaseballException {
    public static void numListSize(List<Integer> list, int listSize) {
        if(list.size() > listSize)
            throw new IllegalArgumentException("3자리 숫자만 가능합니다.");
    }
}
