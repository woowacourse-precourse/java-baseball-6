package baseball.service;

import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallsGenerator {

    private static final int MAX_BALL_SIZE = 3;
    private static final int MINIMUM_RANDOM_NUMBER = 1;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;


    private int generateRandomBall() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }

    private List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < MAX_BALL_SIZE) {
            int randomNumber = generateRandomBall();
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public List<Balls> generateComputerNumbers() {
        List<Integer> numbers = generateUniqueNumbers();
        List<Balls> computers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int value = numbers.get(i);
            computers.add(new Balls(value, i));
        }
        return computers;
    }

    public List<Balls> generatePlayerNumbers(List<String> values) {
        List<Balls> ballsList = new ArrayList<>();
        for (int i = 0; i < MAX_BALL_SIZE; i++) {
            ballsList.add(new Balls(Integer.parseInt(values.get(i)), i));
        }
        return ballsList;
    }
}
