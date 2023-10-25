package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Stream;

public class BaseBallGame {

    private final static int NUMBER_COUNT = 3;
    private int ball;
    private int strike;
    private final int[] randomNumbers;

    private int[] userNumbers;

    public BaseBallGame() {
        randomNumbers = makeRandomNumbers();
    }

    public void start() {

        do {
            System.out.print("숫자를 입력해주세요 : ");

            String input = Console.readLine();
            String[] userNumberStr = input.split("");
            int[] userNumberInt = stringToInt(userNumberStr);

            checkEnableUserNumber(userNumberInt);
            checkBallAndStrike();

        } while (!isGameOver());

    }

    private int[] stringToInt(String[] numbersStr) {
        try {
            return Stream.of(numbersStr).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 외의 문자가 입력되었습니다.");
        }
    }

    public void checkEnableUserNumber(int[] userNumbers) {

        this.userNumbers = userNumbers;
        this.ball = 0;
        this.strike = 0;

        checkNumberCount();
        checkDupliate();
        checkNotExistZero();

    }

    private void checkBallAndStrike() {

        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (userNumbers[i] == randomNumbers[i]) {
                strike++;
                continue;
            }

            for (int j = 0; j < NUMBER_COUNT; j++) {
                if (userNumbers[i] == randomNumbers[j]) {
                    ball++;
                    break;
                }
            }
        }

    }

    private boolean isGameOver() {

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (ball > 0) {
            System.out.print(ball + "볼" + (strike == 0 ? "\n" : " "));
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == NUMBER_COUNT) {
            System.out.println(NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;

    }

    private static boolean isDuplicate(int[] numbers, int findNumber) {
        for (int number : numbers) {
            if (number == findNumber) {
                return true;
            }
        }
        return false;
    }

    private int[] makeRandomNumbers() {
        int[] randomNumbers = new int[NUMBER_COUNT];
        int index = 0;

        do {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!isDuplicate(randomNumbers, randomNumber)) {
                randomNumbers[index] = randomNumber;
                index++;
            }
        } while (index < NUMBER_COUNT);

        return randomNumbers;
    }

    // 배열에 0이 없는지 체크
    private void checkNotExistZero() {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (userNumbers[i] == 0) {
                throw new IllegalArgumentException("숫자에 0이 포함되어 있습니다.");
            }
        }
    }

    // 서로 다른 수인지 체크
    private void checkDupliate() {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            for (int j = 0; j < NUMBER_COUNT; j++) {
                if (i != j && userNumbers[i] == userNumbers[j]) {
                    throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
                }
            }
        }
    }

    // 입력 숫자 갯수 체크
    private void checkNumberCount() {
        if (userNumbers.length != NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자 갯수가 " + NUMBER_COUNT + "와 일치하지 않습니다.");
        }
    }

}
