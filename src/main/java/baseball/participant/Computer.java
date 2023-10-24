package baseball.participant;

import baseball.slot.RandomBaseballNumbersSlot;

public class Computer extends Participant {
    public Computer() {
        super(new RandomBaseballNumbersSlot());
    }

    public void refreshAnswer() {
        numbersSlot.updateNumbers();
    }
}
