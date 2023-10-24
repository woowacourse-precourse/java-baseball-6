package baseball.utils;

import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private List<Integer> numbers;
    int strikeCount;
    int ballCount;
    SystemMessage systemMessage = new SystemMessage();

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount() {
        this.strikeCount = 0;
    }

    public void setNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.numbers = computer;
    }

    public void compareNumbers(List<Integer> randomNumber, String input) {
        int[] inputNumber;
        this.strikeCount = 0;
        this.ballCount = 0;
        if (!checkSize(input)) {
            throw new IllegalArgumentException();
        } else {
            inputNumber = getParsedInt(input);
        }
        for (int index = 0; index < randomNumber.size(); index++) {
            if (randomNumber.contains(inputNumber[index])) {
                if (randomNumber.get(index) == inputNumber[index]) {
                    this.strikeCount++;
                } else {
                    this.ballCount++;
                }
            }
        }
    }

    public void comparedResult() {
        systemMessage.printResultMessage(this.ballCount, this.strikeCount);
    }

    private boolean checkSize(String input) {
        return input.length() == 3;
    }

    private int[] getParsedInt(String input) {
        int[] parsedInt = new int[3];
        String[] InputArray = input.split("");
        for (int i = 0; i < input.length(); i++) {
            if (!checkRange(input, i)) {
                throw new IllegalArgumentException();
            } else {
                parsedInt[i] = Integer.parseInt(InputArray[i]);
            }
        }
        return parsedInt;
    }

    private boolean checkRange(String input, int index) {
        return '1' <= input.charAt(index) && input.charAt(index) <= '9';
    }
}