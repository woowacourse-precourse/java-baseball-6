package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private final int START_INCLUSIVE=1;
    private final int END_INCLUSIVE=9;
    private final int LENGTH=3;

    private static class LazyHolder{
        public static final Computer INSTANCE=new Computer();
    }

    public static Computer getInstance(){
        return LazyHolder.INSTANCE;
    }
}
