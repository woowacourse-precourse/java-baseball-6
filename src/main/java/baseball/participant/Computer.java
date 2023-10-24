package baseball.participant;

import baseball.slot.RandomBaseballNumbersSlot;

/**
 * 컴퓨터의 계산을 처리하는 클래스.
 * <p>같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 제공한다.
 */
public class Computer extends Participant {
    public Computer() {
        super(new RandomBaseballNumbersSlot());
    }

    public void refreshAnswer() {
        numbersSlot.updateNumbers();
    }
}
