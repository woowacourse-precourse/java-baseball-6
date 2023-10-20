package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberBaseballGame {
    private static final int MAX_NUMBER_LENGTH = 3;
    List<Integer> computer = new ArrayList<>(MAX_NUMBER_LENGTH);

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        boolean isContinue = true;
        while (isContinue) {
            computer = generateRandomNumbers();
            playGame();
            isContinue = getUserContinueInput();
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
        while (generatedNumbers.size() < MAX_NUMBER_LENGTH) {
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
        if (!Pattern.matches(userInputRegex, inputString)) {
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
        return strike == MAX_NUMBER_LENGTH;
    }

    private int countBall(List<Integer> user) {
        int ball = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computer.contains(user.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private boolean getUserContinueInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputContinue = Console.readLine();
        validateUserContinueInput(inputContinue);
        return inputContinue.equals("1");
    }

    private void validateUserContinueInput(String inputContinueS) {
        if (!inputContinueS.equals("1") && !inputContinueS.equals("2")) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2 를 입력하세요.");
        }
    }
}
