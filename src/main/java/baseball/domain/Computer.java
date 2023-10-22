package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer implements IPlayer {

    private final int NUMBER_BALLS;
    private List<Integer> numbers;

    public Computer(final int NUMBER_BALLS) {
        this.NUMBER_BALLS = NUMBER_BALLS;
        this.numbers = generateRandomNumber(NUMBER_BALLS);
    }

    @Override
    public void generatePlayerNumber(int NUMBER_BALLS) {
        numbers = generateRandomNumber(NUMBER_BALLS);
    }

    @Override
    public Response respondsTo(IPlayer opponentUser) {
        int strikeCount = 0;
        int ballCount = 0;
        int index = 0;

        for (int ball : numbers) {
            if (opponentUser.checkIfIsStrike(ball, index++)) {
                ++strikeCount;
            } else if (opponentUser.checkIfIsBall(ball)) {
                ++ballCount;
            }
        }

        return new Response(new ArrayList<>(Arrays.asList(strikeCount, ballCount)), NUMBER_BALLS);
    }

    @Override
    public boolean checkIfIsStrike(int ball, int index) {
        return numbers.get(index) == ball;
    }

    @Override
    public boolean checkIfIsBall(int ball) {
        return numbers.contains(ball);
    }

    @Override
    public int countNumberBalls() {
        return numbers.size();
    }

    private List<Integer> generateRandomNumber(int NUMBER_BALLS) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_BALLS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

}
