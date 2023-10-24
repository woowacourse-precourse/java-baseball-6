package baseball.console.game.numberbaseball.domain.system;

import baseball.console.game.numberbaseball.util.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameNumber {
    List<Integer> numberList;
    private final int hundredDigit;
    private final int tenDigit;
    private final int oneDigit;

    public GameNumber(int number) {
        hundredDigit = NumberUtils.getHundredDigit(number);
        tenDigit = NumberUtils.getTenDigit(number);
        oneDigit = NumberUtils.getOneDigit(number);
        numberList = new ArrayList<>(Arrays.asList(hundredDigit, tenDigit, oneDigit));
    }

    public GameNumber(List<Integer> numbers) {
        numberList = numbers;
        hundredDigit = numbers.get(0);
        tenDigit = numbers.get(1);
        oneDigit = numbers.get(2);
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
