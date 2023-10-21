package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class PlayGame {

    private int ball;
    private int strike;

    public void userInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String originalInput = Console.readLine();
        ArrayList<Integer> userNumberList = inputToArrayList(originalInput);
    }

    public ArrayList<Integer> inputToArrayList(String numInput) {
        ArrayList<Integer> userNumbers = new ArrayList<>();

        for (char c : numInput.toCharArray()) {
            userNumbers.add(c - '0');
        }

        return userNumbers;
    }
}
