package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ComputerOrganizer {
    private BaseballManager computerNumbers;

    public void createRandomNumbers() {
        List<Integer> randomNumbers = generateRandomNumbers(Constant.fixed_Number_Size);
        this.computerNumbers = new BaseballManager(randomNumbers);
    }

    private List<Integer> generateRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        Set<Integer> usedNumbers = new HashSet<>();
        Random random = new Random();

        while (randomNumbers.size() < size) {
            int randomNumber =
                    random.nextInt(Constant.Maximum_Range - Constant.Minimum_Range + 1) + Constant.Minimum_Range;
            if (usedNumbers.add(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    public Umpire makeUserInputUmpire(BaseballManager userBaseballNumbers) {
        Umpire umpire = new Umpire(computerNumbers, userBaseballNumbers);

        return umpire;
    }
}