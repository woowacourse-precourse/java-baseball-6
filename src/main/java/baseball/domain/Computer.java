package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Computer {

    private List<Integer> secretNumbers;

    public List<Integer> generateRandomNumbers(int startInclusive, int endInclusive, int count) {
        //this.secretNumbers = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        secretNumbers = computer;
        return secretNumbers;


    }

    public Game computeResult(List<Integer> userInputNumbers) {
        // 사용자 입력과 비교하여 스트라이크와 볼 계산
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


    public void setSecretNumbers(List<Integer> secretNumbers) {
        this.secretNumbers = secretNumbers;
    }
}
