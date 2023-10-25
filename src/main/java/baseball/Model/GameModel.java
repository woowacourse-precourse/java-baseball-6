package baseball.Model;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class GameModel {
    private List<Integer> computerNumbers;

    public GameModel() {
        computerNumbers = generateRandomNumbers();
    }


    public void resetGame() {
        computerNumbers = generateRandomNumbers();
    }

    public boolean isGameWon(int[] userNumbers) {
        return calculateStrikes(userNumbers) == 3;
    }


    public int calculateStrikes(int[] userNumbers) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    public int calculateBalls(int[] userNumbers) {
        int balls = 0;
        Set<Integer> uniqueComputerNumbers = new HashSet<>();
        for (int number : computerNumbers) {
            uniqueComputerNumbers.add(number);
        }
        for (int i = 0; i < 3; i++) {
            if (uniqueComputerNumbers.contains(userNumbers[i]) && userNumbers[i] != computerNumbers.get(i)) {
                balls++;
            }
        }
        return balls;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    // generateRandomNumbers 메서드로 컴퓨터 숫자 생성
    private List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
