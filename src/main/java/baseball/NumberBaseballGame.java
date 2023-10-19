package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseballGame {
    List<Integer> computer = new ArrayList<>(3);

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        computer = generateRandomNumbers();
        boolean isContinue = true;
        while (isContinue) {
            playGame();
        }
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

        validateUserInput(inputString); // 예외처리 미구현

        return inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    // 예외처리 미구현
    private boolean validateUserInput(String inputString) {
        return true;
    }
}
