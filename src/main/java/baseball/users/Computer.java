package baseball.users;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer extends User {
    private int start, end, count;

    public Computer() {
        this(1, 9, 3);
    }

    public Computer(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    @Override
    public void setInningNumbers() {
        while (sizeOfInningNumbers() < count) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            if (!containsInningNumbers(randomNumber)) {
                addInningNumbers(randomNumber);
            }
        }
    }
}
