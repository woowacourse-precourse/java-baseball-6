package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private int length;
    private List<Integer> numbers;

    public ComputerNumber(int length) {
        this.length = length;
        createNumber();
    }

    private void createNumber() {
        this.numbers = new ArrayList<>();
        while (numbers.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public int[] compare(List<Integer> playerNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < length; i++) {
            int playerNumber = playerNumbers.get(i);
            int computerNumber = this.numbers.get(i);
            if (computerNumber == playerNumber) {
                strike++;
                continue;
            }
            if (numbers.contains(playerNumber)) {
                ball++;
            }
        }
        return new int[]{ball, strike};
    }
}
