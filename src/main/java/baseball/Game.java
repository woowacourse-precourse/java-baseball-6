package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> randomInt;
    private List<Integer> userInput;

    public Game() {
        SetRandomInt();
    }

    public void SetRandomInt() {
        randomInt = new ArrayList<>();
        while (randomInt.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomInt.contains(randomNumber)) {
                randomInt.add(randomNumber);
            }
        }
    }

    public void getUserInput() {
        userInput = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        for (int j = 0; j < input.length(); j++) {
            userInput.add(input.charAt(j) - '0');
        }
    }
}
