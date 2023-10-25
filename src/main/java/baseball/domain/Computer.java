package baseball.domain;

import baseball.ui.Output;
import baseball.utils.Utility;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer implements Player {

    private final Output output;
    private List<Integer> numbers;
    private Response response;

    public Computer(Output output) {
        this.output = output;
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

        response = new Response(List.of(strikeCount, ballCount), numbers.size());
    }

    public int countNumberBalls() {
        return numbers.size();
    }

    private void announceResult() {
        output.print(Utility.convertResponseToResult(response));
    }

}
