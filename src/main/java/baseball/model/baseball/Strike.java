package baseball.model.baseball;

import baseball.constants.BaseballRole;

public class Strike {

    private static final int NO_COUNT = 0;

    private int strikeCount;

    public Strike(int count) {
        this.strikeCount = count;
    }

    public void updateStrikeCount(long count){
        this.strikeCount = (int)count;
    }

    public boolean isNoCountStrike(){
        return strikeCount == NO_COUNT;
    }

    public boolean isStrike(){
        return strikeCount != NO_COUNT;
    }

    public boolean isThreeStrike(){
        return strikeCount != BaseballRole.THREE_STRIKE.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(strikeCount);
    }
}
