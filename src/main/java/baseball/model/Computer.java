package baseball.model;

import baseball.Key;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {

    private static String number;

    public void generateNumber() {
        List<Integer> list = new ArrayList<>();

        while(list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randomNumber))
                list.add(randomNumber);
        }

        number = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public Hint compareNumber(String answer) {
        Hint hint = new Hint();

        IntStream.range(0, Key.NUMBER_LENGTH)
                .forEach(index -> {
                    if(answer.charAt(index) == number.charAt(index))
                        hint.increaseStrike();
                    else if(answer.contains(String.valueOf(number.charAt(index))))
                        hint.increaseBall();
                });

        return hint;
    }

    public String getNumber() {
        return number;
    }
}
