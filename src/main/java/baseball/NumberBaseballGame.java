package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberBaseballGame {
    private static final int NUMBER_LENGTH = 3;
    List<Integer> computer = new ArrayList<>(3);

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        computer = generateRandomNumbers();
        boolean isContinue = true;
        while (isContinue) {
            playGame();
            // isContinue = getUserContinueInput();
        }
    }

    private void playGame() {
        boolean userWin = false;
        while (!userWin) {
            List<Integer> user = userNumberInput();
            if (isUserWin(user)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                userWin = true;
            }
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> generatedNumbers = new ArrayList<>();
        while (generatedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        System.out.println(generatedNumbers);
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

    private boolean isUserWin(List<Integer> user) {
        int ball = countBall(user);
        int strike = countStrike(user);
        ball -= strike;
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        return strike == 3;
    }

    private int countBall(List<Integer> user) {
        int ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computer.contains(user.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            }
        }
        return strike;
    }
}
