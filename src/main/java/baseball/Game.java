package baseball;

import java.util.List;

import static baseball.Utils.*;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class Game {
//    private final String winMessage = Messages.WIN_MESSAGE;
    private final Oppoent oppoent;
    private int strike;
    private int ball;

    public Game(Oppoent oppoent){
        this.oppoent = oppoent;
        this.strike = 0;
        this.ball = 0;
    }

    public void initialiser() {
        oppoent.initialiser();
        strike = 0;
        ball = 0;
    }

    public void gamePlay() {
        List<Integer> userNumbers;
        while (strike < DESIGNED_NUM) {
            System.out.println(INPUT_MESSAGE);
            String inputNumbers = readLine();
        }
    }

    private void validateDataType(String inputNumbers) {
        try {
            Integer.parseInt(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The input number is not a Integer");
        }
    }

    private void validateCount(List<Integer> userNumbers) {
        if (userNumbers.size() != DESIGNED_NUM) {
            throw new IllegalArgumentException("The input length is invalid");
        }
        if (userNumbers.stream().distinct().count() != DESIGNED_NUM) {
            throw new IllegalArgumentException("The input numbers are duplicated");
        }
    }

    private void validateRange(List<Integer> userNumbers) {
        for(int number : userNumbers) {
            if(number < START_NUM || number > LAST_NUM) {
                throw new IllegalArgumentException("The input number is out of range");
            }
        }
    }
}
