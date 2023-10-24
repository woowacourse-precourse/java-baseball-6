package baseball.participant;

import baseball.slot.BaseballNumbersSlot;

public abstract class Participant {
    protected final BaseballNumbersSlot numbersSlot;

    protected Participant(BaseballNumbersSlot numbersSlot) {
        this.numbersSlot = numbersSlot;
    }

    public BaseballNumbersSlot getSlot() {
        return numbersSlot;
    }
}
