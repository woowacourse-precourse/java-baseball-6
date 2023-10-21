package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Stream;

public class Application {

    // 야구게임 숫자 갯수
    public final static int NUMBER_COUNT = 3;

    public static void main(String[] args) {

        boolean restart = true;

        String number;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart) {
            int[] randomNumbers = getRandomNumbers();
            while (true) {
                int strike = 0;
                int ball = 0;

                System.out.print("숫자를 입력해주세요 : ");

                number = Console.readLine();
                String[] numbersStr = number.split("");
                int[] numbersInt = stringToInt(numbersStr);

                checkNumberCount(numbersInt);
                checkDupliate(numbersInt);
                checkNotExistZero(numbersInt);

                // 랜덤 숫자랑 동일한지 체크
                for (int i = 0; i < NUMBER_COUNT; i++) {
                    if (numbersInt[i] == randomNumbers[i]) {
                        strike++;
                        continue;
                    }

                    for (int j = 0; j < NUMBER_COUNT; j++) {
                        if (randomNumbers[j] == numbersInt[i]) {
                            ball++;
                            continue;
                        }
                    }
                }

                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                }

                if (ball > 0) {
                    System.out.print(ball + "볼" + (strike == 0 ? "\n" : " "));
                }
                if (strike > 0) {
                    System.out.println(strike + "스트라이크");
                }
                if (strike == NUMBER_COUNT) {
                    System.out.println(NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String input = Console.readLine();
                    restart = input.equals("1") ? true : false;
                    break;
                }

            }
        }

    }

    private static int[] stringToInt(String[] numbersStr) {
        try {
            int[] numbersInt = Stream.of(numbersStr).mapToInt(Integer::parseInt).toArray();
            return numbersInt;
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 외의 문자가 입력되었습니다.");
        }
    }

    // 배열에 0이 없는지 체크
    private static void checkNotExistZero(int[] numbersInt) {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (numbersInt[i] == 0) {
                throw new IllegalArgumentException("숫자에 0이 포함되어 있습니다.");
            }
        }
    }

    // 서로 다른 수인지 체크
    private static void checkDupliate(int[] numbersInt) {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            for (int j = 0; j < NUMBER_COUNT; j++) {
                if (i != j && numbersInt[i] == numbersInt[j]) {
                    throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
                }
            }
        }
    }

    // 입력 숫자 갯수 체크
    private static void checkNumberCount(int[] numbersInt) {
        if (numbersInt.length != NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자 갯수가 " + NUMBER_COUNT + "와 일치하지 않습니다.");
        }
    }

    private static int[] getRandomNumbers() {
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

    private static boolean isDuplicate(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;
    }
}
