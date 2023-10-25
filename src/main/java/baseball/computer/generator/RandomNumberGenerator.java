package baseball.computer.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int REQUIRED_NUMBERS_SIZE = 3;
    private List<Integer> numbers;

    public RandomNumberGenerator() {
        generateNumbers();
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean isNumberExisted(int number){
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public List<Integer> generateNewNumbers(){
        generateNumbers();
        return getNumbers();
    }

    private void generateNumbers() {
        numbers = new ArrayList<>();
        while (numbers.size() < REQUIRED_NUMBERS_SIZE) {
            addUniqueRandomNumber();
        }
    }

    private void addUniqueRandomNumber() {
        int randomNumber = generateRandomNumber();
        if (!isNumberExisted(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
