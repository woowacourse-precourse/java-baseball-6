package baseball.domain;

import baseball.ui.ConsoleOutput;
import baseball.utils.Utility;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer implements IPlayer {

    private final ConsoleOutput consoleOutput;
    private final int NUMBER_BALLS;
    private List<Integer> numbers;
    private Response response;

    public Computer(ConsoleOutput consoleOutput, final int NUMBER_BALLS) {
        this.consoleOutput = consoleOutput;
        this.NUMBER_BALLS = NUMBER_BALLS;
    }

    @Override
    public void generatePlayerNumber(int NUMBER_BALLS) {
        numbers = generateRandomNumber(NUMBER_BALLS);
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

    public boolean respondsTo(User user) {
        checkResult(user);
        announceResult();

        return response.isWrongAnswer();
    }

    private void checkResult(User user) {
        int strikeCount = 0;
        int ballCount = 0;
        int index = 0;

        for (int ball : numbers) {
            if (user.checkIfIsStrike(ball, index++)) {
                ++strikeCount;
            } else if (user.checkIfIsBall(ball)) {
                ++ballCount;
            }
        }

        response = new Response(List.of(strikeCount, ballCount), NUMBER_BALLS);
    }

    public int countNumberBalls() {
        return numbers.size();
    }

    private void announceResult() {
        consoleOutput.printMessage(Utility.convertResponseToResult(response));
    }

}
