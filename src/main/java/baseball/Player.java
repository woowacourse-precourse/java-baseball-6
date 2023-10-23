package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Player {
    static int size;
    static int lowerBound;
    static int upperBound;
    private final List<Integer> numbers;

    public Player() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(lowerBound, upperBound);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        this.numbers = numbers;
    }

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int containsNumber(int target) {
        return numbers.indexOf(target) + 1;
    }

    public int[] compareWith(Player another) {
        int strike = 0;
        int ball = 0;

        for (int i = 1; i <= numbers.size(); i++) {
            int myNumber = numbers.get(i - 1);
            int anotherNumberAt = another.containsNumber(myNumber);
            if (anotherNumberAt == i) {  // strike
                strike++;
            } else if (anotherNumberAt > 0) {  // ball
                ball++;
            }
        }
        return new int[] {strike, ball};
    }
}
