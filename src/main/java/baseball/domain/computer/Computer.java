package baseball.domain.computer;

import baseball.domain.number.Number;
import baseball.domain.player.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.number.Number.MAX_NUMBER;
import static baseball.domain.number.Number.MIN_NUMBER;
import static baseball.domain.player.Player.*;

public class Computer {
    private List<Number> answerNumbers;

    private Computer(List<Number> numbers) {
        this.answerNumbers = numbers;
    }

    public static Computer createComputerAnswerByRandomGenerator() {
        List<Number> answerNumbers = integerToNumber(generateNumbers());
        return new Computer(answerNumbers);
    }

    public static Computer from(Player answerNumbers) {
        return new Computer(answerNumbers.getNumbers());
    }

    private static ArrayList<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != BASEBALL_NUMBERS_LIMIT_SIZE) {
            numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return new ArrayList<>(numbers);
    }

    public List<Number> getAnswerNumbers() {
        return answerNumbers;
    }
}
