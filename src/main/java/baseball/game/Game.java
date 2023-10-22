package baseball.game;

import baseball.object.Computer;
import baseball.Key;
import baseball.object.Hint;

import java.util.stream.IntStream;

public class Game {

    public static void compareNumber(String answer) {

        String number = Computer.getNumber();
        IntStream.range(0, Key.NUMBER_LENGTH)
                .forEach(index -> {
                    if(answer.charAt(index) == number.charAt(index))
                        Hint.increaseStrike();
                    else if(answer.contains(String.valueOf(number.charAt(index))))
                        Hint.increaseBall();
                });
    }
}
