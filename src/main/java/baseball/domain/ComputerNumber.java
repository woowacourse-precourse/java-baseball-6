package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static baseball.util.MagicNumber.*;

public class ComputerNumber {

    private final AnswerNumber answerNumber;
    private final GameResult gameResult;

    public ComputerNumber() {
        answerNumber = new AnswerNumber(makeNumber());
        gameResult = new GameResult();
    }

    public List<Integer> makeNumber() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < MAX_SIZE.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber());
            uniqueNumbers.add(randomNumber);
        }

        return new ArrayList<>(uniqueNumbers);
    }

    public void verifyNumber(List<Integer> number) {
        gameResult.setStrike(verifyStrike(answerNumber.getNumber(), number));
        gameResult.setBall(verifyBall(answerNumber.getNumber(), number));
    }

    public int verifyStrike(List<Integer> answer, List<Integer> userNumber) {
        return (int) IntStream.range(MIN_SIZE.getNumber(), userNumber.size())
                .filter(i -> answer.get(i).equals(userNumber.get(i)))
                .count();
    }

    public int verifyBall(List<Integer> answer, List<Integer> userNumber) {
        return (int) IntStream.range(MIN_SIZE.getNumber(), userNumber.size())
                .filter(i -> !answer.get(i).equals(userNumber.get(i)) && answer.contains(userNumber.get(i)))
                .count();
    }

    public boolean verifyEnd() {
        return gameResult.getStrike() == MAX_SIZE.getNumber();
    }

    public int getStrike() {
        return gameResult.getStrike();
    }

    public int getBall() {
        return gameResult.getBall();
    }

}
