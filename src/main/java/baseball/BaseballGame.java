package baseball;

import camp.nextstep.edu.missionutils.Console;

import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Integer> answerNumbers;

    public BaseballGame(List<Integer> answer) {
        this.answerNumbers = answer;
    }


    public void play() {
        int strikeCount = 0;
        int ballCount = 0;

        do {
            MessagePrinter.printGetNumberMessage();
            List<Integer> playerGuess = convertNumber(getNumber());

            strikeCount = NumberJudgement.countStrike(playerGuess, answerNumbers);
            ballCount = NumberJudgement.countBall(playerGuess, answerNumbers);

            MessagePrinter.printResultMessage(strikeCount, ballCount);
        }
        while (strikeCount != 3);
        MessagePrinter.printGameEndMessage();
    }

    public String getNumber() {
        return Console.readLine();
    }

    public List<Integer> convertNumber(String inputNumber) {
        InputValidator.checkPlayerNumber(inputNumber);

        List<Integer> numbers = new ArrayList<>();
        for (char c : inputNumber.toCharArray()) {
            numbers.add(Integer.parseInt(String.valueOf(c)));
        }
        return numbers;
    }

}
