package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberBaseballGame {
    List<Integer> computer = new ArrayList<>(3);

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        computer = generateRandomNumbers();
        boolean isContinue = true;
        playGame();
    }

    private void playGame() {
        List<Integer> user = new ArrayList<>();
        user = userNumberInput();
        System.out.println(user);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> generatedNumbers = new ArrayList<>();
        while (generatedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        return generatedNumbers;
    }

    private List<Integer> userNumberInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();

        validateUserInput(inputString);

        return inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    // 예외처리 미구현
    private boolean validateUserInput(String inputString) throws IllegalArgumentException {
        String userInputRegex = "^[1-9]{3}$";
        if (!Pattern.matches("^[0-9]{3}$", inputString)) {
            System.out.println("잘못된 숫자 입력입니다: " + inputString);
            throw new IllegalArgumentException("잘못된 숫자 입력입니다: " + inputString);
        }
        return true;
    }
}
