package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    private static void pickComputerNumber(List<Integer> computerNumber) {
        int randomNumber;
        while (computerNumber.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private static void playGame(List<Integer> computerNumber) throws IllegalArgumentException {
        String userInput = "";
        List<Integer> parsedUserInput = new ArrayList<>();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();
            if (userInput.length() != 3) {
                throw new IllegalArgumentException();
            }
            parseString(parsedUserInput, userInput);
            if (calc(parsedUserInput, computerNumber)) {
                return;
            }
            parsedUserInput.clear();
        }
    }
    }
}
