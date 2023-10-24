package baseball.domain.computer;

import baseball.domain.player.Player;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    private final Computer computer;

    public ComputerService(Computer computer) {
        this.computer = computer;
    }

    public void generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        computer.updateNumbers(numbers);
    }

    public void resetNumbers() {
        generateRandomNumbers();
    }

    public boolean compare(Player player) {
        int[] count = count(player);
        print(count[0], count[1]);
        return count[0] == 3;
    }

    public int[] count(Player player) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.getIndexNumbers(i) == player.getIndexNumbers(j) && i == j) {
                    strikeCount++;
                } else if (computer.getIndexNumbers(i) == player.getIndexNumbers(j)) {
                    ballCount++;
                }
            }
        }
        return new int[]{strikeCount, ballCount};
    }

    public void print(int strikeCount, int ballCount) {
        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }


}
