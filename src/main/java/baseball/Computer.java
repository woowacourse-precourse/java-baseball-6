package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answer;

    Computer() {
        initializeAnswer();
    }

    public void initializeAnswer() {
        this.answer = getNewAnswer();
    }

    private List<Integer> getNewAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private List<Integer> getUserInput() throws IllegalArgumentException {
        String in = Console.readLine();
        if (in.length() != 3) {
            throw new IllegalArgumentException();
        }
        List<Integer> guess = new ArrayList<>();
        for (int i = 0; i < in.length(); ++i) {
            char ch = in.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
            int element = Character.getNumericValue(in.charAt(i));
            if (element == 0 || guess.contains(element)) {
                throw new IllegalArgumentException();
            }
            guess.add(Character.getNumericValue(ch));
        }
        return guess;
    }
}
