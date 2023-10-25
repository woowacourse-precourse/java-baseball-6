package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerPlayer {
    private int[] numbers;

    public ComputerPlayer() {
        numbers = new int[3];
    }

//    public int[] getNumbers() {
//        return numbers;
//    }
//
//    public void setNumbers(int[] numbers) {
//        this.numbers = numbers.clone();
//    }

    public int[] generateRandomNumber() {
        for (int i = 0; i < 3; i++) {
            numbers[i] = Randoms.pickNumberInRange(1, 9);
        }
        return numbers;
    }
}
