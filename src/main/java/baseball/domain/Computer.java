package baseball.domain;

import static baseball.constants.GameConstants.COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {

    private List<Integer> secretNumbers;

    public void setSecretNumbers(List<Integer> secretNumbers) {
        this.secretNumbers = secretNumbers;
    }

    public List<Integer> generateRandomNumbers(int startInclusive, int endInclusive, int count) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COUNT) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        setSecretNumbers(computer);
        return secretNumbers;

    }

    // secretNumbers를 사용자 입력과 비교하여 스트라이크와 볼 count 계산
    public Game computeResult(List<Integer> userInputNumbers) {

        int strikes = 0;
        int balls = 0;

        strikes = (int) IntStream.range(0, 3)
                .filter(index -> userInputNumbers.get(index).equals(secretNumbers.get(index)))
                .count();

        int matchingNumberCount = (int) userInputNumbers.stream()
                .filter(secretNumbers::contains)
                .count();

        balls = matchingNumberCount - strikes;

        return new Game(strikes, balls);
    }

}
