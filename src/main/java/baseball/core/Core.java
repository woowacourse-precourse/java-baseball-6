package baseball.core;

import java.util.List;

public class Core {
    public boolean isDigitStrike(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        return computerNumber.get(index).equals(userNumber.get(index));
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (isDigitStrike(computerNumber, userNumber, index)) {
                count++;
            }
        }
        return count;
    }

    public boolean isDigitBall(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        if (isDigitStrike(computerNumber, userNumber, index)) {
            return false;
        }
        for (int cur = 0; cur < computerNumber.size(); cur++) {
            if (index == cur) {
                continue;
            }
            if (userNumber.get(index) == computerNumber.get(cur)) {
                return true;
            }
        }
        return false;
    }

    public int countBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (isDigitBall(computerNumber, userNumber, index)) {
                count++;
            }
        }
        return count;
    }

    public void printGameResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikes > 0 && balls > 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
            return;
        }
        if (strikes > 0) {
            System.out.printf("%d스트라이크\n", strikes);
            return;
        }
        if (balls > 0) {
            System.out.printf("%d볼\n", balls);
        }
    }
}