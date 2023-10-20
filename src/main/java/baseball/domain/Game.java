package baseball.domain;

import static baseball.domain.Baseball.createAnswer;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    Baseball answer;

    public Game() {
        answer = createAnswer();
    }

    public void start() {
        System.out.println("숫자를 입력해주세요 : ");
        Integer userInput = validate(readLine());
        Baseball guessNumber = new Baseball(userInput);
    }

    private int validate(String input) {
        Integer intInput = 0;
        try {
            intInput = Integer.parseInt(input);
            if (intInput < 100 || intInput >= 999) {
                throw new IllegalArgumentException();
            }
            Integer hundreds = intInput / 100;
            Integer tens = (intInput / 10) % 10;
            Integer ones = intInput % 10;
            if (hundreds.equals(0) || tens.equals(0) || ones.equals(0)) {
                throw new IllegalArgumentException();
            }
            if (hundreds.equals(tens) || hundreds.equals(ones) || tens.equals(ones)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return intInput;
    }
}
