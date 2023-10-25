package baseball;

import java.util.Arrays;
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
        System.out.println(START_MESSAGE);
        while (strike < DESIGNED_NUM) {
            System.out.print(INPUT_MESSAGE);
            String inputNumbers = readLine();
            validateDataType(inputNumbers);
            userNumbers = toIntegerList(inputNumbers);
            validateCount(userNumbers);
            validateRange(userNumbers);

            strike = oppoent.checkStrike(userNumbers);
            ball = oppoent.checkBall(userNumbers);

            printHint();
        }
        printWinMessage();
    }
    private List<Integer> toIntegerList(String inputNumbers) {
        String[] splitInput = inputNumbers.split("");
        return Arrays
                .stream(splitInput)
                .map(Integer :: parseInt)
                .toList();
    }

    private void printHint() {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append(BALL).append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append(STRIKE);
        }
        System.out.println(sb.toString());
    }

    private void printWinMessage() {
        System.out.println(WIN_MESSAGE);
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
