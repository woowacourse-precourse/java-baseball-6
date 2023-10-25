package baseball.model.baseball;

import baseball.constants.BaseballRole;

public class Strike {

    private int strikeCount;

    public Strike(int count) {
        this.strikeCount = count;
    }

    public void updateStrikeCount(long count){
        this.strikeCount = (int)count;
    }

    public boolean isNoCountStrike(){
        return strikeCount == BaseballRole.NO_COUNT.getValue();
    }

    public boolean isStrike(){
        return strikeCount != BaseballRole.NO_COUNT.getValue();
    }

    public boolean isNotThreeStrike(){
        return strikeCount != BaseballRole.THREE_STRIKE.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(strikeCount);
    }
}
